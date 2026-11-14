/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 *
 * Helper modifiers and composables that apply CardVisualParams to real UI.
 * Use these inside FolderCard / VideoCard so the chosen style actually changes the rendered card.
 */

package app.gyrolet.mpvrx.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

/**
 * Applies shape, elevation (shadow), border and background according to CardVisualParams.
 * Call this on the outermost container of the card content.
 */
@Composable
fun Modifier.cardVisualStyle(
  params: CardVisualParams,
  shape: Shape = params.toShape(),
  baseBackground: Color = MaterialTheme.colorScheme.surfaceContainerHigh,
): Modifier {
  var mod = this
    .shadow(
      elevation = params.elevation,
      shape = shape,
      clip = false,
      ambientColor = if (params.neonGlow) params.borderColor.copy(alpha = 0.45f) else Color.Black.copy(alpha = 0.25f),
      spotColor = if (params.neonGlow) params.borderColor.copy(alpha = 0.6f) else Color.Black.copy(alpha = 0.35f),
    )
    .clip(shape)

  // Background
  mod = if (params.useGradient && params.gradientColors.size >= 2) {
    mod.background(
      brush = Brush.linearGradient(params.gradientColors),
      shape = shape,
    )
  } else {
    val bg = when {
      params.amoled -> Color.Black
      params.glassEffect -> baseBackground.copy(alpha = params.backgroundAlpha)
      else -> baseBackground.copy(alpha = params.backgroundAlpha)
    }
    mod.background(bg, shape)
  }

  // Border
  if (params.borderWidth > 0.dp) {
    mod = mod.border(
      width = params.borderWidth,
      color = params.borderColor,
      shape = shape,
    )
  }

  return mod
}

/**
 * Content padding derived from the style.
 */
fun Modifier.cardContentPadding(params: CardVisualParams): Modifier =
  this.padding(
    horizontal = params.contentPaddingHorizontal,
    vertical = params.contentPaddingVertical,
  )
