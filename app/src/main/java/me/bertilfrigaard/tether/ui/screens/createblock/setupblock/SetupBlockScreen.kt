package me.bertilfrigaard.tether.ui.screens.createblock.setupblock

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import me.bertilfrigaard.tether.ui.screens.home.HomeScreenContent
import me.bertilfrigaard.tether.ui.screens.home.HomeViewModel

@Composable
fun SetupBlockScreen(vm: SetupBlockViewModel, goBack: () -> Unit, goToSelectApps: () -> Unit) {
    val state by vm.uiState.collectAsStateWithLifecycle()
    SetupBlockContent(state, goBack, goToSelectApps)
}