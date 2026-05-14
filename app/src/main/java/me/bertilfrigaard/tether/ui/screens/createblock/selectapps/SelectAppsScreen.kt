package me.bertilfrigaard.tether.ui.screens.createblock.selectapps

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SelectAppsScreen(vm: SelectAppsViewModel, goBack: () -> Unit) {
    val state by vm.uiState.collectAsStateWithLifecycle()
    SelectAppsContent(state, goBack)
}