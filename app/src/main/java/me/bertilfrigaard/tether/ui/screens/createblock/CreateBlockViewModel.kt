package me.bertilfrigaard.tether.ui.screens.createblock

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.bertilfrigaard.tether.MainApplication
import me.bertilfrigaard.tether.data.model.AppInfo
import me.bertilfrigaard.tether.data.model.Block
import me.bertilfrigaard.tether.ui.screens.createblock.setupblock.SetupBlockUiState

data class CreateBlockUiState(
    val selectedApps: List<AppInfo> = emptyList(),
    var isCreating: Boolean = false
)

class CreateBlockViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CreateBlockUiState())
    val uiState: StateFlow<CreateBlockUiState> = _uiState.asStateFlow()
    private val blockRepository = MainApplication.instance.blockRepository

    fun setSelectedApps(apps: List<AppInfo>) {
        _uiState.update { it.copy(selectedApps = apps) }
    }

    fun createBlock(setup: SetupBlockUiState) {
        _uiState.update { it.copy(isCreating = true) }
        val block = Block(
            name = "?",
            enabled = true,
            blockCondition = setup.selectedCondition,
            dailyUsageLimit = setup.dailyUsage,
            allowPass = setup.allowPass,
            delayPassGrant = setup.delayPassGrant,
            maxPassLength = setup.maxPassLength,
            passCooldown = setup.passCooldown,
            packageNames = _uiState.value.selectedApps.map { it.packageName }
        )

        viewModelScope.launch {
            blockRepository.createBlock(block)
            _uiState.update { it.copy(isCreating = false) }
        }
    }
}
