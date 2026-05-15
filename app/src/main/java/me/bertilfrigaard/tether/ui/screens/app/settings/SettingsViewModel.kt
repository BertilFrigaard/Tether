package me.bertilfrigaard.tether.ui.screens.app.settings

import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import me.bertilfrigaard.tether.MainApplication

data class SettingsUiState(
    val hasOverlayPermission: Boolean = false,
    val hasUsageStatsPermission: Boolean = false,
    val hasNotificationPermission: Boolean = false
)

class SettingsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    private val appPermissionsDataSource = MainApplication.instance.appPermissionsDataSource

    init {
        refreshPermissions()
    }

    fun refreshPermissions() {
        _uiState.update { it.copy(
            hasOverlayPermission = appPermissionsDataSource.hasOverlayPermission(),
            hasUsageStatsPermission = appPermissionsDataSource.hasUsageStatsPermission(),
            hasNotificationPermission = appPermissionsDataSource.hasNotificationPermission()
        ) }
    }

    fun getOverlaySettingsIntent() = appPermissionsDataSource.getOverlaySettingsIntent()
    fun getNotificationSettingsIntent() = appPermissionsDataSource.getNotificationSettingsIntent()
    fun getUsageStatsSettingsIntent() = appPermissionsDataSource.getUsageStatsSettingsIntent()
}