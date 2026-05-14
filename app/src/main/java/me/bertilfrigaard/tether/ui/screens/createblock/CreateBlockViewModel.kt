package me.bertilfrigaard.tether.ui.screens.createblock

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import me.bertilfrigaard.tether.data.model.AppInfo

data class CreateBlockUiState(
    val selectedApps: List<AppInfo> = emptyList(),
    val blockName: String = "Unnamed block",
)

class CreateBlockViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CreateBlockUiState())
    val uiState: StateFlow<CreateBlockUiState> = _uiState.asStateFlow()

    fun setSelectedApps(apps: List<AppInfo>) {
        _uiState.update { it.copy(selectedApps = apps) }
    }

    fun setBlockName(name: String) {
        _uiState.update { it.copy(blockName = name) }
    }
}