/*
 * SPDX-License-Identifier: AGPL-3.0-or-later
 * Visual Design System – 40 real styles per category.
 */

package app.gyrolet.mpvrx.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/* ========================= 40 Styles ========================= */

enum class FolderCardStyle(val id: Int, val displayName: String) {
  CLASSIC(0, "Classic"), GLASS(1, "Glass"), NEON(2, "Neon"), COMPACT(3, "Compact"),
  WIDE(4, "Wide"), BORDERED(5, "Bordered"), MINIATURE(6, "Miniature"), ARTISTIC(7, "Artistic"),
  THREE_D(8, "3D"), CUSTOM_IMAGE(9, "Custom Image"), MATERIAL_YOU(10, "Material You"),
  AMOLED(11, "AMOLED"), SOFT(12, "Soft"), SHARP(13, "Sharp"), FLOATING(14, "Floating"),
  FROSTED(15, "Frosted"), OUTLINE(16, "Outline"), ELEVATED(17, "Elevated"), FLAT(18, "Flat"),
  GRADIENT(19, "Gradient"), RETRO(20, "Retro"), CYBER(21, "Cyber"), PAPER(22, "Paper"),
  INK(23, "Ink"), LUXURY(24, "Luxury"), DUAL_TONE(25, "Dual Tone"), SHADOW(26, "Shadow"),
  GLOW(27, "Glow"), METAL(28, "Metal"), CRYSTAL(29, "Crystal"), MIDNIGHT(30, "Midnight"),
  SUNSET(31, "Sunset"), OCEAN(32, "Ocean"), FOREST(33, "Forest"), EMBER(34, "Ember"),
  ARCTIC(35, "Arctic"), VIOLET(36, "Violet"), GOLDEN(37, "Golden"), SILVER(38, "Silver"),
  CARBON(39, "Carbon");
  companion object { fun fromId(id: Int) = entries.find { it.id == id } ?: CLASSIC }
}

enum class VideoCardStyle(val id: Int, val displayName: String) {
  CLASSIC(0, "Classic"), GLASS(1, "Glass"), NEON(2, "Neon"), COMPACT(3, "Compact"),
  WIDE(4, "Wide"), BORDERED(5, "Bordered"), CINEMATIC(6, "Cinematic"), POSTER(7, "Poster"),
  LIST(8, "List"), GRID_DENSE(9, "Dense Grid"), PROGRESS_FOCUS(10, "Progress Focus"),
  MINIMAL(11, "Minimal"), MATERIAL(12, "Material"), AMOLED(13, "AMOLED"), FLOATING(14, "Floating"),
  FROSTED(15, "Frosted"), OUTLINE(16, "Outline"), ELEVATED(17, "Elevated"), FLAT(18, "Flat"),
  GRADIENT(19, "Gradient"), RETRO(20, "Retro"), CYBER(21, "Cyber"), PAPER(22, "Paper"),
  INK(23, "Ink"), LUXURY(24, "Luxury"), DUAL_TONE(25, "Dual Tone"), SHADOW(26, "Shadow"),
  GLOW(27, "Glow"), METAL(28, "Metal"), CRYSTAL(29, "Crystal"), MIDNIGHT(30, "Midnight"),
  SUNSET(31, "Sunset"), OCEAN(32, "Ocean"), FOREST(33, "Forest"), EMBER(34, "Ember"),
  ARCTIC(35, "Arctic"), VIOLET(36, "Violet"), GOLDEN(37, "Golden"), SILVER(38, "Silver"),
  CARBON(39, "Carbon");
  companion object { fun fromId(id: Int) = entries.find { it.id == id } ?: CLASSIC }
}

enum class BarStyle(val id: Int, val displayName: String) {
  CLASSIC(0, "Classic"), GLASS(1, "Glass"), NEON(2, "Neon"), SOLID(3, "Solid"),
  TRANSPARENT(4, "Transparent"), GRADIENT(5, "Gradient"), FLOATING(6, "Floating"),
  COMPACT(7, "Compact"), MATERIAL(8, "Material"), AMOLED(9, "AMOLED"), BLUR(10, "Blur"),
  BORDERED(11, "Bordered"), SOFT(12, "Soft"), SHARP(13, "Sharp"), DYNAMIC(14, "Dynamic"),
  FROSTED(15, "Frosted"), OUTLINE(16, "Outline"), ELEVATED(17, "Elevated"), FLAT(18, "Flat"),
  RETRO(19, "Retro"), CYBER(20, "Cyber"), PAPER(21, "Paper"), INK(22, "Ink"),
  LUXURY(23, "Luxury"), MINIMAL(24, "Minimal"), DUAL_TONE(25, "Dual Tone"), SHADOW(26, "Shadow"),
  GLOW(27, "Glow"), METAL(28, "Metal"), CRYSTAL(29, "Crystal"), MIDNIGHT(30, "Midnight"),
  SUNSET(31, "Sunset"), OCEAN(32, "Ocean"), FOREST(33, "Forest"), EMBER(34, "Ember"),
  ARCTIC(35, "Arctic"), VIOLET(36, "Violet"), GOLDEN(37, "Golden"), SILVER(38, "Silver"),
  CARBON(39, "Carbon");
  companion object { fun fromId(id: Int) = entries.find { it.id == id } ?: CLASSIC }
}

enum class FolderIconStyle(val id: Int, val displayName: String) {
  CLASSIC(0, "Classic"), ROUNDED(1, "Rounded"), SQUARE(2, "Square"), CIRCLE(3, "Circle"),
  HEXAGON(4, "Hexagon"), GLASS(5, "Glass"), NEON(6, "Neon"), THREE_D(7, "3D"),
  OUTLINE(8, "Outline"), FILLED(9, "Filled"), MINIMAL(10, "Minimal"), ARTISTIC(11, "Artistic"),
  CUSTOM(12, "Custom"), SOFT(13, "Soft"), SHARP(14, "Sharp"), FLOATING(15, "Floating"),
  FROSTED(16, "Frosted"), GRADIENT(17, "Gradient"), RETRO(18, "Retro"), CYBER(19, "Cyber"),
  PAPER(20, "Paper"), INK(21, "Ink"), LUXURY(22, "Luxury"), MATERIAL(23, "Material"),
  AMOLED(24, "AMOLED"), DUAL_TONE(25, "Dual Tone"), SHADOW(26, "Shadow"), GLOW(27, "Glow"),
  METAL(28, "Metal"), CRYSTAL(29, "Crystal"), MIDNIGHT(30, "Midnight"), SUNSET(31, "Sunset"),
  OCEAN(32, "Ocean"), FOREST(33, "Forest"), EMBER(34, "Ember"), ARCTIC(35, "Arctic"),
  VIOLET(36, "Violet"), GOLDEN(37, "Golden"), SILVER(38, "Silver"), CARBON(39, "Carbon");
  companion object { fun fromId(id: Int) = entries.find { it.id == id } ?: CLASSIC }
}

enum class CardDensityMode(val id: Int, val displayName: String) {
  COMPACT(0, "Compact"), BALANCED(1, "Balanced"), EXPANDED(2, "Expanded");
  companion object { fun fromId(id: Int) = entries.find { it.id == id } ?: BALANCED }
}

@Immutable
data class CardVisualParams(
  val cornerRadius: Dp = 12.dp,
  val elevation: Dp = 2.dp,
  val borderWidth: Dp = 0.dp,
  val borderColor: Color = Color.Transparent,
  val backgroundAlpha: Float = 1f,
  val contentPaddingHorizontal: Dp = 12.dp,
  val contentPaddingVertical: Dp = 10.dp,
  val thumbnailCornerRadius: Dp = 8.dp,
  val titleMaxLines: Int = 2,
  val showProgress: Boolean = true,
  val showDuration: Boolean = true,
  val showSize: Boolean = false,
  val showDate: Boolean = false,
  val glassEffect: Boolean = false,
  val neonGlow: Boolean = false,
  val amoled: Boolean = false,
  val useGradient: Boolean = false,
  val gradientColors: List<Color> = emptyList(),
  val accentColor: Color? = null,
)

fun CardVisualParams.toShape(): Shape = RoundedCornerShape(cornerRadius)

private val NeonCyan = Color(0xFF00E5FF)
private val NeonPink = Color(0xFFFF00E5)
private val NeonGreen = Color(0xFF39FF14)
private val LuxuryGold = Color(0xFFD4AF37)
private val CyberPurple = Color(0xFF9D4EDD)
private val OceanBlue = Color(0xFF0077B6)
private val ForestGreen = Color(0xFF2D6A4F)
private val EmberOrange = Color(0xFFE85D04)
private val ArcticCyan = Color(0xFF90E0EF)
private val Violet = Color(0xFF7B2CBF)
private val Silver = Color(0xFFC0C0C0)
private val Carbon = Color(0xFF2B2B2B)
private val SunsetOrange = Color(0xFFFF6B35)
private val Midnight = Color(0xFF0D1B2A)

fun FolderCardStyle.toVisualParams(): CardVisualParams = when (this) {
  FolderCardStyle.CLASSIC -> CardVisualParams()
  FolderCardStyle.GLASS -> CardVisualParams(cornerRadius=16.dp, elevation=0.dp, backgroundAlpha=0.62f, glassEffect=true, borderWidth=1.dp, borderColor=Color.White.copy(0.22f))
  FolderCardStyle.NEON -> CardVisualParams(cornerRadius=14.dp, elevation=4.dp, borderWidth=1.5.dp, borderColor=NeonCyan, neonGlow=true, backgroundAlpha=0.88f)
  FolderCardStyle.COMPACT -> CardVisualParams(cornerRadius=8.dp, elevation=1.dp, contentPaddingHorizontal=8.dp, contentPaddingVertical=6.dp, titleMaxLines=1)
  FolderCardStyle.WIDE -> CardVisualParams(cornerRadius=10.dp, contentPaddingHorizontal=16.dp, thumbnailCornerRadius=6.dp)
  FolderCardStyle.BORDERED -> CardVisualParams(cornerRadius=12.dp, borderWidth=2.dp, borderColor=Color.White.copy(0.28f), elevation=0.dp)
  FolderCardStyle.MINIATURE -> CardVisualParams(cornerRadius=10.dp, contentPaddingHorizontal=6.dp, contentPaddingVertical=4.dp, titleMaxLines=1)
  FolderCardStyle.ARTISTIC -> CardVisualParams(cornerRadius=20.dp, elevation=6.dp, thumbnailCornerRadius=16.dp)
  FolderCardStyle.THREE_D -> CardVisualParams(cornerRadius=12.dp, elevation=10.dp)
  FolderCardStyle.CUSTOM_IMAGE -> CardVisualParams(cornerRadius=12.dp, elevation=3.dp)
  FolderCardStyle.MATERIAL_YOU -> CardVisualParams(cornerRadius=16.dp, elevation=1.dp)
  FolderCardStyle.AMOLED -> CardVisualParams(cornerRadius=12.dp, elevation=0.dp, amoled=true)
  FolderCardStyle.SOFT -> CardVisualParams(cornerRadius=24.dp, elevation=2.dp)
  FolderCardStyle.SHARP -> CardVisualParams(cornerRadius=4.dp, elevation=1.dp)
  FolderCardStyle.FLOATING -> CardVisualParams(cornerRadius=16.dp, elevation=12.dp, backgroundAlpha=0.95f)
  FolderCardStyle.FROSTED -> CardVisualParams(cornerRadius=18.dp, elevation=0.dp, backgroundAlpha=0.55f, glassEffect=true, borderWidth=1.dp, borderColor=Color.White.copy(0.18f))
  FolderCardStyle.OUTLINE -> CardVisualParams(cornerRadius=12.dp, elevation=0.dp, borderWidth=1.5.dp, borderColor=Color.White.copy(0.4f), backgroundAlpha=0.15f)
  FolderCardStyle.ELEVATED -> CardVisualParams(cornerRadius=14.dp, elevation=8.dp)
  FolderCardStyle.FLAT -> CardVisualParams(cornerRadius=8.dp, elevation=0.dp, backgroundAlpha=0.9f)
  FolderCardStyle.GRADIENT -> CardVisualParams(cornerRadius=14.dp, elevation=3.dp, useGradient=true, gradientColors=listOf(Color(0xFF667eea), Color(0xFF764ba2)))
  FolderCardStyle.RETRO -> CardVisualParams(cornerRadius=6.dp, elevation=2.dp, borderWidth=2.dp, borderColor=Color(0xFFE8D5B7))
  FolderCardStyle.CYBER -> CardVisualParams(cornerRadius=4.dp, elevation=3.dp, borderWidth=1.5.dp, borderColor=CyberPurple, neonGlow=true, backgroundAlpha=0.85f)
  FolderCardStyle.PAPER -> CardVisualParams(cornerRadius=2.dp, elevation=1.dp, borderWidth=1.dp, borderColor=Color(0xFFD0D0D0))
  FolderCardStyle.INK -> CardVisualParams(cornerRadius=0.dp, elevation=0.dp, borderWidth=1.dp, borderColor=Color.White.copy(0.6f), backgroundAlpha=0.1f)
  FolderCardStyle.LUXURY -> CardVisualParams(cornerRadius=16.dp, elevation=6.dp, borderWidth=1.5.dp, borderColor=LuxuryGold, backgroundAlpha=0.92f)
  FolderCardStyle.DUAL_TONE -> CardVisualParams(cornerRadius=12.dp, elevation=3.dp, useGradient=true, gradientColors=listOf(Color(0xFF434343), Color(0xFF000000)))
  FolderCardStyle.SHADOW -> CardVisualParams(cornerRadius=12.dp, elevation=14.dp)
  FolderCardStyle.GLOW -> CardVisualParams(cornerRadius=14.dp, elevation=6.dp, neonGlow=true, borderWidth=1.dp, borderColor=NeonCyan)
  FolderCardStyle.METAL -> CardVisualParams(cornerRadius=8.dp, elevation=4.dp, borderWidth=1.dp, borderColor=Silver, backgroundAlpha=0.9f)
  FolderCardStyle.CRYSTAL -> CardVisualParams(cornerRadius=20.dp, elevation=2.dp, backgroundAlpha=0.45f, glassEffect=true, borderWidth=1.dp, borderColor=Color.White.copy(0.35f))
  FolderCardStyle.MIDNIGHT -> CardVisualParams(cornerRadius=12.dp, elevation=2.dp, amoled=true, accentColor=Midnight)
  FolderCardStyle.SUNSET -> CardVisualParams(cornerRadius=14.dp, elevation=3.dp, useGradient=true, gradientColors=listOf(SunsetOrange, Color(0xFFFF9F1C)), accentColor=SunsetOrange)
  FolderCardStyle.OCEAN -> CardVisualParams(cornerRadius=14.dp, elevation=3.dp, borderWidth=1.dp, borderColor=OceanBlue, accentColor=OceanBlue)
  FolderCardStyle.FOREST -> CardVisualParams(cornerRadius=12.dp, elevation=2.dp, borderWidth=1.dp, borderColor=ForestGreen, accentColor=ForestGreen)
  FolderCardStyle.EMBER -> CardVisualParams(cornerRadius=12.dp, elevation=3.dp, borderWidth=1.5.dp, borderColor=EmberOrange, neonGlow=true, accentColor=EmberOrange)
  FolderCardStyle.ARCTIC -> CardVisualParams(cornerRadius=16.dp, elevation=1.dp, backgroundAlpha=0.7f, glassEffect=true, borderColor=ArcticCyan, borderWidth=1.dp, accentColor=ArcticCyan)
  FolderCardStyle.VIOLET -> CardVisualParams(cornerRadius=14.dp, elevation=3.dp, borderWidth=1.dp, borderColor=Violet, accentColor=Violet)
  FolderCardStyle.GOLDEN -> CardVisualParams(cornerRadius=16.dp, elevation=5.dp, borderWidth=1.5.dp, borderColor=LuxuryGold, accentColor=LuxuryGold)
  FolderCardStyle.SILVER -> CardVisualParams(cornerRadius=12.dp, elevation=3.dp, borderWidth=1.dp, borderColor=Silver, accentColor=Silver)
  FolderCardStyle.CARBON -> CardVisualParams(cornerRadius=8.dp, elevation=2.dp, amoled=true, borderWidth=1.dp, borderColor=Carbon, accentColor=Carbon)
}

fun VideoCardStyle.toVisualParams(): CardVisualParams = when (this) {
  VideoCardStyle.CLASSIC -> CardVisualParams()
  VideoCardStyle.GLASS -> CardVisualParams(cornerRadius=14.dp, elevation=0.dp, backgroundAlpha=0.68f, glassEffect=true, borderWidth=1.dp, borderColor=Color.White.copy(0.18f))
  VideoCardStyle.NEON -> CardVisualParams(cornerRadius=12.dp, borderWidth=1.5.dp, borderColor=NeonPink, neonGlow=true)
  VideoCardStyle.COMPACT -> CardVisualParams(cornerRadius=8.dp, contentPaddingHorizontal=8.dp, contentPaddingVertical=6.dp, titleMaxLines=1, showSize=false, showDate=false)
  VideoCardStyle.WIDE -> CardVisualParams(cornerRadius=10.dp, contentPaddingHorizontal=14.dp)
  VideoCardStyle.BORDERED -> CardVisualParams(borderWidth=2.dp, borderColor=Color.White.copy(0.22f), elevation=0.dp)
  VideoCardStyle.CINEMATIC -> CardVisualParams(cornerRadius=6.dp, elevation=4.dp, titleMaxLines=1)
  VideoCardStyle.POSTER -> CardVisualParams(cornerRadius=8.dp, contentPaddingVertical=4.dp)
  VideoCardStyle.LIST -> CardVisualParams(cornerRadius=8.dp, elevation=0.dp, contentPaddingHorizontal=12.dp)
  VideoCardStyle.GRID_DENSE -> CardVisualParams(cornerRadius=6.dp, contentPaddingHorizontal=4.dp, contentPaddingVertical=4.dp, titleMaxLines=1, showDuration=true, showSize=false)
  VideoCardStyle.PROGRESS_FOCUS -> CardVisualParams(cornerRadius=12.dp, showProgress=true, showDuration=true)
  VideoCardStyle.MINIMAL -> CardVisualParams(cornerRadius=8.dp, elevation=0.dp, showSize=false, showDate=false)
  VideoCardStyle.MATERIAL -> CardVisualParams(cornerRadius=16.dp, elevation=1.dp)
  VideoCardStyle.AMOLED -> CardVisualParams(cornerRadius=10.dp, elevation=0.dp, amoled=true)
  VideoCardStyle.FLOATING -> CardVisualParams(cornerRadius=16.dp, elevation=8.dp)
  VideoCardStyle.FROSTED -> CardVisualParams(cornerRadius=16.dp, elevation=0.dp, backgroundAlpha=0.58f, glassEffect=true, borderWidth=1.dp, borderColor=Color.White.copy(0.16f))
  VideoCardStyle.OUTLINE -> CardVisualParams(cornerRadius=10.dp, elevation=0.dp, borderWidth=1.5.dp, borderColor=Color.White.copy(0.38f), backgroundAlpha=0.12f)
  VideoCardStyle.ELEVATED -> CardVisualParams(cornerRadius=12.dp, elevation=7.dp)
  VideoCardStyle.FLAT -> CardVisualParams(cornerRadius=6.dp, elevation=0.dp)
  VideoCardStyle.GRADIENT -> CardVisualParams(cornerRadius=12.dp, elevation=3.dp, useGradient=true, gradientColors=listOf(Color(0xFF11998e), Color(0xFF38ef7d)))
  VideoCardStyle.RETRO -> CardVisualParams(cornerRadius=4.dp, elevation=2.dp, borderWidth=2.dp, borderColor=Color(0xFFE8D5B7))
  VideoCardStyle.CYBER -> CardVisualParams(cornerRadius=2.dp, elevation=3.dp, borderWidth=1.5.dp, borderColor=NeonGreen, neonGlow=true, backgroundAlpha=0.82f)
  VideoCardStyle.PAPER -> CardVisualParams(cornerRadius=2.dp, elevation=1.dp, borderWidth=1.dp, borderColor=Color(0xFFC8C8C8))
  VideoCardStyle.INK -> CardVisualParams(cornerRadius=0.dp, elevation=0.dp, borderWidth=1.dp, borderColor=Color.White.copy(0.55f), backgroundAlpha=0.08f)
  VideoCardStyle.LUXURY -> CardVisualParams(cornerRadius=14.dp, elevation=5.dp, borderWidth=1.5.dp, borderColor=LuxuryGold, backgroundAlpha=0.9f)
  VideoCardStyle.DUAL_TONE -> CardVisualParams(cornerRadius=12.dp, elevation=3.dp, useGradient=true, gradientColors=listOf(Color(0xFF434343), Color(0xFF000000)))
  VideoCardStyle.SHADOW -> CardVisualParams(cornerRadius=12.dp, elevation=12.dp)
  VideoCardStyle.GLOW -> CardVisualParams(cornerRadius=12.dp, elevation=5.dp, neonGlow=true, borderWidth=1.dp, borderColor=NeonPink)
  VideoCardStyle.METAL -> CardVisualParams(cornerRadius=8.dp, elevation=3.dp, borderWidth=1.dp, borderColor=Silver)
  VideoCardStyle.CRYSTAL -> CardVisualParams(cornerRadius=18.dp, elevation=2.dp, backgroundAlpha=0.5f, glassEffect=true, borderWidth=1.dp, borderColor=Color.White.copy(0.3f))
  VideoCardStyle.MIDNIGHT -> CardVisualParams(cornerRadius=10.dp, elevation=2.dp, amoled=true, accentColor=Midnight)
  VideoCardStyle.SUNSET -> CardVisualParams(cornerRadius=12.dp, elevation=3.dp, useGradient=true, gradientColors=listOf(SunsetOrange, Color(0xFFFF9F1C)), accentColor=SunsetOrange)
  VideoCardStyle.OCEAN -> CardVisualParams(cornerRadius=12.dp, elevation=2.dp, borderWidth=1.dp, borderColor=OceanBlue, accentColor=OceanBlue)
  VideoCardStyle.FOREST -> CardVisualParams(cornerRadius=12.dp, elevation=2.dp, borderWidth=1.dp, borderColor=ForestGreen, accentColor=ForestGreen)
  VideoCardStyle.EMBER -> CardVisualParams(cornerRadius=12.dp, elevation=3.dp, borderWidth=1.5.dp, borderColor=EmberOrange, neonGlow=true, accentColor=EmberOrange)
  VideoCardStyle.ARCTIC -> CardVisualParams(cornerRadius=14.dp, elevation=1.dp, backgroundAlpha=0.7f, glassEffect=true, borderColor=ArcticCyan, borderWidth=1.dp, accentColor=ArcticCyan)
  VideoCardStyle.VIOLET -> CardVisualParams(cornerRadius=12.dp, elevation=3.dp, borderWidth=1.dp, borderColor=Violet, accentColor=Violet)
  VideoCardStyle.GOLDEN -> CardVisualParams(cornerRadius=14.dp, elevation=4.dp, borderWidth=1.5.dp, borderColor=LuxuryGold, accentColor=LuxuryGold)
  VideoCardStyle.SILVER -> CardVisualParams(cornerRadius=10.dp, elevation=3.dp, borderWidth=1.dp, borderColor=Silver, accentColor=Silver)
  VideoCardStyle.CARBON -> CardVisualParams(cornerRadius=8.dp, elevation=2.dp, amoled=true, borderWidth=1.dp, borderColor=Carbon, accentColor=Carbon)
}

@Immutable
data class VisualCustomizationState(
  val folderCardStyle: FolderCardStyle = FolderCardStyle.CLASSIC,
  val videoCardStyle: VideoCardStyle = VideoCardStyle.CLASSIC,
  val episodeCardStyle: VideoCardStyle = VideoCardStyle.CLASSIC,
  val topBarStyle: BarStyle = BarStyle.CLASSIC,
  val bottomBarStyle: BarStyle = BarStyle.CLASSIC,
  val folderIconStyle: FolderIconStyle = FolderIconStyle.CLASSIC,
  val cardDensity: CardDensityMode = CardDensityMode.BALANCED,
  val cardWidthScale: Float = 1.0f,
  val cardHeightScale: Float = 1.0f,
  val cardSpacingScale: Float = 1.0f,
  val thumbnailSizeScale: Float = 1.0f,
  val cornerRadiusOverride: Float? = null,
  val borderWidthOverride: Float? = null,
  val backgroundAlphaOverride: Float? = null,
  val customBorderColor: Long? = null,
  val customAccentColor: Long? = null,
  val showProgress: Boolean = true,
  val showDuration: Boolean = true,
  val showFileSize: Boolean = false,
  val showDate: Boolean = false,
  val enableGlass: Boolean = true,
  val enableNeonGlow: Boolean = true,
)

fun resolveCardParams(base: CardVisualParams, state: VisualCustomizationState): CardVisualParams {
  var p = base
  state.cornerRadiusOverride?.let { p = p.copy(cornerRadius = it.dp) }
  state.borderWidthOverride?.let { p = p.copy(borderWidth = it.dp) }
  state.backgroundAlphaOverride?.let { p = p.copy(backgroundAlpha = it) }
  state.customBorderColor?.let { p = p.copy(borderColor = Color(it)) }
  state.customAccentColor?.let { p = p.copy(accentColor = Color(it)) }
  if (!state.enableGlass) p = p.copy(glassEffect = false)
  if (!state.enableNeonGlow) p = p.copy(neonGlow = false)
  p = p.copy(
    showProgress = state.showProgress && p.showProgress,
    showDuration = state.showDuration && p.showDuration,
    showSize = state.showFileSize || p.showSize,
    showDate = state.showDate || p.showDate,
  )
  return p
}
