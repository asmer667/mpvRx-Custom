/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 *
 * Live preview screen for the visual design system.
 * Shows real-looking cards driven by the selected styles and scales.
 * Uses the same CardVisualParams that FolderCard / VideoCard will consume.
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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import app.gyrolet.mpvrx.preferences.VisualCustomizationPreferences
import app.gyrolet.mpvrx.preferences.preference.collectAsState
import app.gyrolet.mpvrx.ui.theme.CardVisualParams
import app.gyrolet.mpvrx.ui.theme.FolderCardStyle
import app.gyrolet.mpvrx.ui.theme.VideoCardStyle
import app.gyrolet.mpvrx.ui.theme.cardContentPadding
import app.gyrolet.mpvrx.ui.theme.cardVisualStyle
import app.gyrolet.mpvrx.ui.theme.resolveCardParams
import app.gyrolet.mpvrx.ui.theme.toVisualParams
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisualLivePreviewScreen(
  onBack: () -> Unit = {},
  onApply: () -> Unit = {},
  modifier: Modifier = Modifier,
) {
  val prefs = koinInject<VisualCustomizationPreferences>()
  val state = prefs.currentState()

  var previewFolderStyle by remember { mutableStateOf(state.folderCardStyle) }
  var previewVideoStyle by remember { mutableStateOf(state.videoCardStyle) }

  val folderParams = resolveCardParams(previewFolderStyle.toVisualParams(), state)
  val videoParams = resolveCardParams(previewVideoStyle.toVisualParams(), state)

  Scaffold(
    modifier = modifier,
    topBar = {
      TopAppBar(title = { Text("Live Visual Preview") })
    },
  ) { padding ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(padding),
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
      // ---------- Folder styles selector ----------
      item {
        Text("Folder Card Style", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
          items(FolderCardStyle.entries) { style ->
            FilterChip(
              selected = previewFolderStyle == style,
              onClick = { previewFolderStyle = style },
              label = { Text(style.displayName) },
            )
          }
        }
      }

      // ---------- Live Folder Card Preview ----------
      item {
        Text("Folder Preview (real params)", style = MaterialTheme.typography.titleSmall)
        Spacer(Modifier.height(8.dp))
        PreviewFolderCard(
          title = "Movies Collection",
          subtitle = "128 videos • 245 GB",
          params = folderParams,
          modifier = Modifier.fillMaxWidth(),
        )
      }

      // ---------- Video styles selector ----------
      item {
        Text("Video Card Style", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
          items(VideoCardStyle.entries) { style ->
            FilterChip(
              selected = previewVideoStyle == style,
              onClick = { previewVideoStyle = style },
              label = { Text(style.displayName) },
            )
          }
        }
      }

      // ---------- Live Video Card Previews ----------
      item {
        Text("Video Preview (real params)", style = MaterialTheme.typography.titleSmall)
        Spacer(Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
          PreviewVideoCard(
            title = "Episode 01 – The Beginning",
            duration = "24:15",
            progress = 0.65f,
            params = videoParams,
            modifier = Modifier.weight(1f),
          )
          PreviewVideoCard(
            title = "Episode 02 – Rising Action",
            duration = "22:48",
            progress = 0.0f,
            params = videoParams,
            modifier = Modifier.weight(1f),
          )
        }
      }

      // ---------- Apply / Cancel ----------
      item {
        Spacer(Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
          Button(
            onClick = {
              prefs.folderCardStyle.set(previewFolderStyle)
              prefs.videoCardStyle.set(previewVideoStyle)
              onApply()
            },
            modifier = Modifier.weight(1f),
          ) {
            Text("Apply Styles")
          }
          Button(
            onClick = onBack,
            modifier = Modifier.weight(1f),
          ) {
            Text("Back")
          }
        }
        Spacer(Modifier.height(8.dp))
        Text(
          text = "These previews use the exact same CardVisualParams that FolderCard and VideoCard consume. Applying writes the selection to persistent preferences.",
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
      }
    }
  }
}

/* -------------------------------------------------------------------------- */
/* Lightweight but realistic preview cards driven by CardVisualParams          */
/* -------------------------------------------------------------------------- */

@Composable
private fun PreviewFolderCard(
  title: String,
  subtitle: String,
  params: CardVisualParams,
  modifier: Modifier = Modifier,
) {
  Box(
    modifier = modifier
      .cardVisualStyle(params)
      .cardContentPadding(params),
  ) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      // Thumbnail placeholder
      Box(
        modifier = Modifier
          .size(72.dp)
          .clip(RoundedCornerShape(params.thumbnailCornerRadius))
          .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center,
      ) {
        Text("📁", style = MaterialTheme.typography.headlineSmall)
      }
      Spacer(Modifier.width(12.dp))
      Column(modifier = Modifier.weight(1f)) {
        Text(
          text = title,
          style = MaterialTheme.typography.titleMedium,
          maxLines = params.titleMaxLines,
          overflow = TextOverflow.Ellipsis,
          fontWeight = FontWeight.SemiBold,
        )
        Spacer(Modifier.height(2.dp))
        Text(
          text = subtitle,
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          maxLines = 1,
        )
      }
    }
  }
}

@Composable
private fun PreviewVideoCard(
  title: String,
  duration: String,
  progress: Float,
  params: CardVisualParams,
  modifier: Modifier = Modifier,
) {
  Column(
    modifier = modifier
      .cardVisualStyle(params)
      .cardContentPadding(params),
  ) {
    // Thumbnail area
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(16f / 9f)
        .clip(RoundedCornerShape(params.thumbnailCornerRadius))
        .background(MaterialTheme.colorScheme.surfaceVariant),
      contentAlignment = Alignment.Center,
    ) {
      Text("▶", style = MaterialTheme.typography.headlineMedium)
      if (params.showDuration) {
        Text(
          text = duration,
          style = MaterialTheme.typography.labelSmall,
          color = Color.White,
          modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(6.dp)
            .background(Color.Black.copy(alpha = 0.7f), RoundedCornerShape(4.dp))
            .padding(horizontal = 6.dp, vertical = 2.dp),
        )
      }
    }
    Spacer(Modifier.height(8.dp))
    Text(
      text = title,
      style = MaterialTheme.typography.bodyMedium,
      maxLines = params.titleMaxLines,
      overflow = TextOverflow.Ellipsis,
      fontWeight = FontWeight.Medium,
    )
    if (params.showProgress && progress > 0f) {
      Spacer(Modifier.height(6.dp))
      LinearProgressIndicator(
        progress = { progress },
        modifier = Modifier
          .fillMaxWidth()
          .height(3.dp)
          .clip(RoundedCornerShape(2.dp)),
      )
    }
  }
}
