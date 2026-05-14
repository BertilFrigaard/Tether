package me.bertilfrigaard.tether.ui.screens.createblock.setupblock

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class SetupBlockUiState(
    val test: String = "Default Value"
)

class SetupBlockViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(SetupBlockUiState())
    val uiState: StateFlow<SetupBlockUiState> = _uiState.asStateFlow()

    fun updateTest(test: String) {
        _uiState.update { it.copy(test = test) }
    }
}
