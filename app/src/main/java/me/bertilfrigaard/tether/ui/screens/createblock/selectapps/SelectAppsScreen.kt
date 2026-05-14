package me.bertilfrigaard.tether.ui.screens.createblock.selectapps

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import me.bertilfrigaard.tether.ui.screens.createblock.CreateBlockViewModel

@Composable
fun SelectAppsScreen(vm: SelectAppsViewModel, sharedVm: CreateBlockViewModel, goBack: () -> Unit) {
    val state by vm.uiState.collectAsStateWithLifecycle()

    fun confirmSelection() {
        Log.d("SelectAppsScreen", "Confirming selection")
        sharedVm.setSelectedApps(state.selectedApps)
        goBack()
    }

    LaunchedEffect(vm, sharedVm) {
        vm.setSelectedApps(sharedVm.uiState.value.selectedApps)
    }

    SelectAppsContent(state = state, updateSearchQuery = vm::updateSearchQuery, goBack = goBack, setSelected = vm::setAppSelected, confirmSelection = { confirmSelection() })
}