/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 * Simple color & transparency editor for the visual system.
 */

package app.gyrolet.mpvrx.ui.preferences

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import app.gyrolet.mpvrx.preferences.VisualCustomizationPreferences
import app.gyrolet.mpvrx.preferences.preference.collectAsState
import org.koin.compose.koinInject

private val PRESET_COLORS = listOf(
  0xFF00E5FF, 0xFFFF00E5, 0xFF39FF14, 0xFFD4AF37, 0xFF9D4EDD,
  0xFF0077B6, 0xFF2D6A4F, 0xFFE85D04, 0xFF90E0EF, 0xFF7B2CBF,
  0xFFC0C0C0, 0xFFFF6B35, 0xFFFFFFFF, 0xFF000000, 0xFFFF1744,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisualColorEditorScreen(
  onBack: () -> Unit = {},
  modifier: Modifier = Modifier,
) {
  val prefs = koinInject<VisualCustomizationPreferences>()
  val currentBorder by prefs.customBorderColor.collectAsState()
  val currentAccent by prefs.customAccentColor.collectAsState()
  val alphaOverride by prefs.backgroundAlphaOverride.collectAsState()
  val radiusOverride by prefs.cornerRadiusOverride.collectAsState()
  val borderWOverride by prefs.borderWidthOverride.collectAsState()

  var borderColor by remember { mutableLongStateOf(if (currentBorder >= 0) currentBorder else 0xFF00E5FF) }
  var accentColor by remember { mutableLongStateOf(if (currentAccent >= 0) currentAccent else 0xFF9D4EDD) }
  var alpha by remember { mutableFloatStateOf(if (alphaOverride >= 0f) alphaOverride else 1f) }
  var radius by remember { mutableFloatStateOf(if (radiusOverride >= 0f) radiusOverride else 12f) }
  var borderW by remember { mutableFloatStateOf(if (borderWOverride >= 0f) borderWOverride else 1.5f) }

  Scaffold(
    modifier = modifier,
    topBar = { TopAppBar(title = { Text("Color & Shape Editor") }) },
  ) { padding ->
    LazyColumn(
      modifier = Modifier.fillMaxSize().padding(padding),
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
      item {
        Text("Border Color", style = MaterialTheme.typography.titleMedium)
        ColorPresets(selected = borderColor) { borderColor = it }
      }
      item {
        Text("Accent Color", style = MaterialTheme.typography.titleMedium)
        ColorPresets(selected = accentColor) { accentColor = it }
      }
      item {
        Text("Background Alpha: ${"%.2f".format(alpha)}", style = MaterialTheme.typography.titleMedium)
        Slider(value = alpha, onValueChange = { alpha = it }, valueRange = 0.1f..1f)
      }
      item {
        Text("Corner Radius: ${radius.toInt()} dp", style = MaterialTheme.typography.titleMedium)
        Slider(value = radius, onValueChange = { radius = it }, valueRange = 0f..32f)
      }
      item {
        Text("Border Width: ${"%.1f".format(borderW)} dp", style = MaterialTheme.typography.titleMedium)
        Slider(value = borderW, onValueChange = { borderW = it }, valueRange = 0f..4f)
      }
      item {
        // Live mini preview
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(radius.dp))
            .background(Color(accentColor).copy(alpha = alpha))
            .border(borderW.dp, Color(borderColor), RoundedCornerShape(radius.dp)),
          contentAlignment = Alignment.Center,
        ) {
          Text("Preview", color = Color.White)
        }
      }
      item {
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
          Button(
            onClick = {
              prefs.customBorderColor.set(borderColor)
              prefs.customAccentColor.set(accentColor)
              prefs.backgroundAlphaOverride.set(alpha)
              prefs.cornerRadiusOverride.set(radius)
              prefs.borderWidthOverride.set(borderW)
            },
            modifier = Modifier.weight(1f),
          ) { Text("Apply") }
          Button(
            onClick = {
              prefs.customBorderColor.set(-1L)
              prefs.customAccentColor.set(-1L)
              prefs.backgroundAlphaOverride.set(-1f)
              prefs.cornerRadiusOverride.set(-1f)
              prefs.borderWidthOverride.set(-1f)
              onBack()
            },
            modifier = Modifier.weight(1f),
          ) { Text("Reset & Back") }
        }
      }
    }
  }
}

@Composable
private fun ColorPresets(selected: Long, onSelect: (Long) -> Unit) {
  Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
  ) {
    PRESET_COLORS.take(8).forEach { colorLong ->
      val color = Color(colorLong)
      Box(
        modifier = Modifier
          .size(36.dp)
          .clip(CircleShape)
          .background(color)
          .border(
            width = if (selected == colorLong) 3.dp else 1.dp,
            color = if (selected == colorLong) MaterialTheme.colorScheme.primary else Color.White.copy(0.3f),
            shape = CircleShape,
          )
          .clickable { onSelect(colorLong) },
      )
    }
  }
  Spacer(Modifier.height(8.dp))
  Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
  ) {
    PRESET_COLORS.drop(8).forEach { colorLong ->
      val color = Color(colorLong)
      Box(
        modifier = Modifier
          .size(36.dp)
          .clip(CircleShape)
          .background(color)
          .border(
            width = if (selected == colorLong) 3.dp else 1.dp,
            color = if (selected == colorLong) MaterialTheme.colorScheme.primary else Color.White.copy(0.3f),
            shape = CircleShape,
          )
          .clickable { onSelect(colorLong) },
      )
    }
  }
}
