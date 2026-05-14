package me.bertilfrigaard.tether.ui.screens.createblock.selectapps

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class SelectAppsUiState(
    val test: String = "Default Value"
)

class SelectAppsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(SelectAppsUiState())
    val uiState: StateFlow<SelectAppsUiState> = _uiState.asStateFlow()

    fun updateTest(test: String) {
        _uiState.update { it.copy(test = test) }
    }
}
