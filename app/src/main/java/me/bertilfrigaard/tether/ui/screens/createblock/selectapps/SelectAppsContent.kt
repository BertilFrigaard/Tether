package me.bertilfrigaard.tether.ui.screens.createblock.selectapps

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SelectAppsContent(state: SelectAppsUiState, goBack: () -> Unit) {
    Text(text = state.test)
}