package me.bertilfrigaard.tether.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(vm: HomeViewModel, goToCreateBlock: () -> Unit, goToViewBlocks: () -> Unit) {
    val state by vm.uiState.collectAsStateWithLifecycle()
    HomeScreenContent(state, goToCreateBlock, goToViewBlocks)
}