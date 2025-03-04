package Server.Views

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable

interface View {
    @Composable
    @Preview
    fun render()
}
