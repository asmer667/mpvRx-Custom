/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 *
 * Settings screen for the new visual design system.
 * Provides real selection of styles with live description.
 * Full live preview of real components will be expanded in later phases.
 */

package app.gyrolet.mpvrx.ui.preferences

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.gyrolet.mpvrx.preferences.VisualCustomizationPreferences
import app.gyrolet.mpvrx.preferences.preference.collectAsState
import app.gyrolet.mpvrx.ui.theme.BarStyle
import app.gyrolet.mpvrx.ui.theme.CardDensityMode
import app.gyrolet.mpvrx.ui.theme.FolderCardStyle
import app.gyrolet.mpvrx.ui.theme.FolderIconStyle
import app.gyrolet.mpvrx.ui.theme.VideoCardStyle
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisualCustomizationScreen(
  onBack: () -> Unit,
  modifier: Modifier = Modifier,
) {
  val prefs = koinInject<VisualCustomizationPreferences>()

  val folderStyle by prefs.folderCardStyle.collectAsState()
  val videoStyle by prefs.videoCardStyle.collectAsState()
  val episodeStyle by prefs.episodeCardStyle.collectAsState()
  val topBarStyle by prefs.topBarStyle.collectAsState()
  val bottomBarStyle by prefs.bottomBarStyle.collectAsState()
  val iconStyle by prefs.folderIconStyle.collectAsState()
  val density by prefs.cardDensity.collectAsState()
  val widthScale by prefs.cardWidthScale.collectAsState()
  val heightScale by prefs.cardHeightScale.collectAsState()
  val spacingScale by prefs.cardSpacingScale.collectAsState()
  val showProgress by prefs.showProgress.collectAsState()
  val showDuration by prefs.showDuration.collectAsState()
  val enableGlass by prefs.enableGlass.collectAsState()
  val enableNeon by prefs.enableNeonGlow.collectAsState()

  Scaffold(
    modifier = modifier,
    topBar = {
      TopAppBar(
        title = { Text("Visual Customization") },
        // navigationIcon can be wired by the host navigation
      )
    },
  ) { padding ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(padding),
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      item {
        SectionHeader("Folder Cards")
      }
      item {
        StyleSelector(
          title = "Folder Card Style",
          current = folderStyle.displayName,
          options = FolderCardStyle.entries.map { it.displayName to it },
          onSelect = { prefs.folderCardStyle.set(it) },
        )
      }

      item {
        SectionHeader("Video & Episode Cards")
      }
      item {
        StyleSelector(
          title = "Video Card Style",
          current = videoStyle.displayName,
          options = VideoCardStyle.entries.map { it.displayName to it },
          onSelect = { prefs.videoCardStyle.set(it) },
        )
      }
      item {
        StyleSelector(
          title = "Episode Card Style",
          current = episodeStyle.displayName,
          options = VideoCardStyle.entries.map { it.displayName to it },
          onSelect = { prefs.episodeCardStyle.set(it) },
        )
      }

      item {
        SectionHeader("Bars")
      }
      item {
        StyleSelector(
          title = "Top Bar Style",
          current = topBarStyle.displayName,
          options = BarStyle.entries.map { it.displayName to it },
          onSelect = { prefs.topBarStyle.set(it) },
        )
      }
      item {
        StyleSelector(
          title = "Bottom Bar Style",
          current = bottomBarStyle.displayName,
          options = BarStyle.entries.map { it.displayName to it },
          onSelect = { prefs.bottomBarStyle.set(it) },
        )
      }

      item {
        SectionHeader("Icons")
      }
      item {
        StyleSelector(
          title = "Folder Icon Style",
          current = iconStyle.displayName,
          options = FolderIconStyle.entries.map { it.displayName to it },
          onSelect = { prefs.folderIconStyle.set(it) },
        )
      }

      item {
        SectionHeader("Density & Size")
      }
      item {
        StyleSelector(
          title = "Card Density",
          current = density.displayName,
          options = CardDensityMode.entries.map { it.displayName to it },
          onSelect = { prefs.cardDensity.set(it) },
        )
      }
      item {
        ScaleSlider(
          title = "Card Width Scale",
          value = widthScale,
          onValueChange = { prefs.cardWidthScale.set(it) },
        )
      }
      item {
        ScaleSlider(
          title = "Card Height Scale",
          value = heightScale,
          onValueChange = { prefs.cardHeightScale.set(it) },
        )
      }
      item {
        ScaleSlider(
          title = "Spacing Scale",
          value = spacingScale,
          onValueChange = { prefs.cardSpacingScale.set(it) },
        )
      }

      item {
        SectionHeader("Information Visibility")
      }
      item {
        SwitchRow(
          title = "Show Progress",
          checked = showProgress,
          onCheckedChange = { prefs.showProgress.set(it) },
        )
      }
      item {
        SwitchRow(
          title = "Show Duration",
          checked = showDuration,
          onCheckedChange = { prefs.showDuration.set(it) },
        )
      }

      item {
        SectionHeader("Effects")
      }
      item {
        SwitchRow(
          title = "Enable Glass Effect",
          checked = enableGlass,
          onCheckedChange = { prefs.enableGlass.set(it) },
        )
      }
      item {
        SwitchRow(
          title = "Enable Neon Glow",
          checked = enableNeon,
          onCheckedChange = { prefs.enableNeonGlow.set(it) },
        )
      }

      item {
        Spacer(Modifier.height(24.dp))
        Text(
          text = "Note: Styles are persisted and will be applied to real cards in the browser. Full live preview components and remaining 25 styles per category will be added in the next development phases.",
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
      }
    }
  }
}

@Composable
private fun SectionHeader(title: String) {
  Text(
    text = title,
    style = MaterialTheme.typography.titleMedium,
    fontWeight = FontWeight.Bold,
    color = MaterialTheme.colorScheme.primary,
    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp),
  )
}

@Composable
private fun <T> StyleSelector(
  title: String,
  current: String,
  options: List<Pair<String, T>>,
  onSelect: (T) -> Unit,
) {
  Card(
    modifier = Modifier.fillMaxWidth(),
    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)),
  ) {
    Column(Modifier.padding(12.dp)) {
      Text(title, style = MaterialTheme.typography.titleSmall)
      Text(
        text = "Current: $current",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp),
      )
      // Simple horizontal chips for selection (expandable later)
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
      ) {
        options.take(5).forEach { (name, value) ->
          val selected = name == current
          Card(
            modifier = Modifier
              .weight(1f)
              .clickable { onSelect(value) },
            colors = CardDefaults.cardColors(
              containerColor = if (selected) MaterialTheme.colorScheme.primaryContainer
              else MaterialTheme.colorScheme.surface,
            ),
          ) {
            Text(
              text = name,
              style = MaterialTheme.typography.labelSmall,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 8.dp),
              maxLines = 1,
            )
          }
        }
      }
      if (options.size > 5) {
        Text(
          text = "+ ${options.size - 5} more styles available",
          style = MaterialTheme.typography.labelSmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          modifier = Modifier.padding(top = 4.dp),
        )
      }
    }
  }
}

@Composable
private fun ScaleSlider(
  title: String,
  value: Float,
  onValueChange: (Float) -> Unit,
) {
  Column {
    Text("$title: ${"%.2f".format(value)}x", style = MaterialTheme.typography.bodyMedium)
    Slider(
      value = value,
      onValueChange = onValueChange,
      valueRange = 0.6f..1.6f,
      steps = 19,
    )
  }
}

@Composable
private fun SwitchRow(
  title: String,
  checked: Boolean,
  onCheckedChange: (Boolean) -> Unit,
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 4.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Text(title, style = MaterialTheme.typography.bodyLarge)
    Switch(checked = checked, onCheckedChange = onCheckedChange)
  }
}
