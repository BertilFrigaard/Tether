package me.bertilfrigaard.tether.ui.screens.createblock.setupblock

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
        state = state,
        sharedState = sharedState,
        goBack,
        goToSelectApps,
        vm::setSelectedCondition,
        vm::setDailyUsage,
        vm::setAllowPass,
        vm::setDelayPassGrant,
        vm::setMaxPassLength,
        vm::setPassCooldown
    )
}