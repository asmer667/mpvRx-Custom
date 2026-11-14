/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 * Persistent storage for the visual design system (40 styles + color overrides).
 */

package app.gyrolet.mpvrx.preferences

import app.gyrolet.mpvrx.preferences.preference.PreferenceStore
import app.gyrolet.mpvrx.preferences.preference.getEnum
import app.gyrolet.mpvrx.ui.theme.BarStyle
import app.gyrolet.mpvrx.ui.theme.CardDensityMode
import app.gyrolet.mpvrx.ui.theme.FolderCardStyle
import app.gyrolet.mpvrx.ui.theme.FolderIconStyle
import app.gyrolet.mpvrx.ui.theme.VideoCardStyle
import app.gyrolet.mpvrx.ui.theme.VisualCustomizationState

class VisualCustomizationPreferences(preferenceStore: PreferenceStore) {

  val folderCardStyle = preferenceStore.getEnum("visual_folder_card_style", FolderCardStyle.CLASSIC)
  val videoCardStyle = preferenceStore.getEnum("visual_video_card_style", VideoCardStyle.CLASSIC)
  val episodeCardStyle = preferenceStore.getEnum("visual_episode_card_style", VideoCardStyle.CLASSIC)
  val topBarStyle = preferenceStore.getEnum("visual_top_bar_style", BarStyle.CLASSIC)
  val bottomBarStyle = preferenceStore.getEnum("visual_bottom_bar_style", BarStyle.CLASSIC)
  val folderIconStyle = preferenceStore.getEnum("visual_folder_icon_style", FolderIconStyle.CLASSIC)
  val cardDensity = preferenceStore.getEnum("visual_card_density", CardDensityMode.BALANCED)
  val cardWidthScale = preferenceStore.getFloat("visual_card_width_scale", 1.0f)
  val cardHeightScale = preferenceStore.getFloat("visual_card_height_scale", 1.0f)
  val cardSpacingScale = preferenceStore.getFloat("visual_card_spacing_scale", 1.0f)
  val thumbnailSizeScale = preferenceStore.getFloat("visual_thumbnail_size_scale", 1.0f)
  val cornerRadiusOverride = preferenceStore.getFloat("visual_corner_radius_override", -1f)
  val borderWidthOverride = preferenceStore.getFloat("visual_border_width_override", -1f)
  val backgroundAlphaOverride = preferenceStore.getFloat("visual_background_alpha_override", -1f)
  val customBorderColor = preferenceStore.getLong("visual_custom_border_color", -1L)
  val customAccentColor = preferenceStore.getLong("visual_custom_accent_color", -1L)
  val showProgress = preferenceStore.getBoolean("visual_show_progress", true)
  val showDuration = preferenceStore.getBoolean("visual_show_duration", true)
  val showFileSize = preferenceStore.getBoolean("visual_show_file_size", false)
  val showDate = preferenceStore.getBoolean("visual_show_date", false)
  val enableGlass = preferenceStore.getBoolean("visual_enable_glass", true)
  val enableNeonGlow = preferenceStore.getBoolean("visual_enable_neon_glow", true)

  fun currentState(): VisualCustomizationState = VisualCustomizationState(
    folderCardStyle = folderCardStyle.get(),
    videoCardStyle = videoCardStyle.get(),
    episodeCardStyle = episodeCardStyle.get(),
    topBarStyle = topBarStyle.get(),
    bottomBarStyle = bottomBarStyle.get(),
    folderIconStyle = folderIconStyle.get(),
    cardDensity = cardDensity.get(),
    cardWidthScale = cardWidthScale.get(),
    cardHeightScale = cardHeightScale.get(),
    cardSpacingScale = cardSpacingScale.get(),
    thumbnailSizeScale = thumbnailSizeScale.get(),
    cornerRadiusOverride = cornerRadiusOverride.get().takeIf { it >= 0f },
    borderWidthOverride = borderWidthOverride.get().takeIf { it >= 0f },
    backgroundAlphaOverride = backgroundAlphaOverride.get().takeIf { it >= 0f },
    customBorderColor = customBorderColor.get().takeIf { it >= 0L },
    customAccentColor = customAccentColor.get().takeIf { it >= 0L },
    showProgress = showProgress.get(),
    showDuration = showDuration.get(),
    showFileSize = showFileSize.get(),
    showDate = showDate.get(),
    enableGlass = enableGlass.get(),
    enableNeonGlow = enableNeonGlow.get(),
  )

  fun resetToDefaults() {
    folderCardStyle.set(FolderCardStyle.CLASSIC)
    videoCardStyle.set(VideoCardStyle.CLASSIC)
    episodeCardStyle.set(VideoCardStyle.CLASSIC)
    topBarStyle.set(BarStyle.CLASSIC)
    bottomBarStyle.set(BarStyle.CLASSIC)
    folderIconStyle.set(FolderIconStyle.CLASSIC)
    cardDensity.set(CardDensityMode.BALANCED)
    cardWidthScale.set(1.0f)
    cardHeightScale.set(1.0f)
    cardSpacingScale.set(1.0f)
    thumbnailSizeScale.set(1.0f)
    cornerRadiusOverride.set(-1f)
    borderWidthOverride.set(-1f)
    backgroundAlphaOverride.set(-1f)
    customBorderColor.set(-1L)
    customAccentColor.set(-1L)
    showProgress.set(true)
    showDuration.set(true)
    showFileSize.set(false)
    showDate.set(false)
    enableGlass.set(true)
    enableNeonGlow.set(true)
  }
}
