package me.bertilfrigaard.tether.ui.screens.app.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeScreen(vm: HomeViewModel, goToCreateBlock: () -> Unit, goToViewBlocks: () -> Unit, goToSettings: () -> Unit) {
    val state by vm.uiState.collectAsStateWithLifecycle()
    HomeScreenContent(
        state,
        goToCreateBlock,
        goToViewBlocks,
        goToSettings
    )
}