package app.gyrolet.mpvrx.ui.preferences

import androidx.compose.runtime.Composable
import app.gyrolet.mpvrx.presentation.Screen
import kotlinx.serialization.Serializable

@Serializable
object VisualColorEditorScreenRoute : Screen {
  @Composable
  override fun Content() {
    VisualColorEditorScreen()
  }
}
