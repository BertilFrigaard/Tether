package me.bertilfrigaard.tether.ui.screens.createblock.setupblock

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.bertilfrigaard.tether.data.model.Block
import me.bertilfrigaard.tether.ui.screens.createblock.CreateBlockViewModel

@Composable
fun SetupBlockScreen(
    vm: SetupBlockViewModel,
    sharedVm: CreateBlockViewModel,
    goBack: () -> Unit,
    goToSelectApps: () -> Unit
) {
    val state by vm.uiState.collectAsStateWithLifecycle()
    val sharedState by sharedVm.uiState.collectAsStateWithLifecycle()

    SetupBlockContent(
        state,
        sharedState,
        goBack,
        goToSelectApps,
        vm::setSelectedCondition,
        vm::setDailyUsage,
        vm::setAllowPass,
        vm::setDelayPassGrant,
        vm::setMaxPassLength,
        vm::setPassCooldown
    ) { sharedVm.createBlock(state); goBack() }
}