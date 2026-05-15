package me.bertilfrigaard.tether.ui.screens.app.viewblocks

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ViewBlocksScreen(vm: ViewBlocksViewModel) {
    val state by vm.uiState.collectAsStateWithLifecycle()
    ViewBlocksContent(state)
}
