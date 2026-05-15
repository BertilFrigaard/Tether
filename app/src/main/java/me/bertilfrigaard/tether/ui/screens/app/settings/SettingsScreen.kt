package me.bertilfrigaard.tether.ui.screens.app.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.LifecycleResumeEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SettingsScreen(vm: SettingsViewModel, goBack: () -> Unit) {
    val state by vm.uiState.collectAsStateWithLifecycle()
    LifecycleResumeEffect(Unit) {
        vm.refreshPermissions()
        onPauseOrDispose {}
    }
    SettingsContent(state, goBack, vm::getOverlaySettingsIntent, vm::getNotificationSettingsIntent, vm::getUsageStatsSettingsIntent)
}