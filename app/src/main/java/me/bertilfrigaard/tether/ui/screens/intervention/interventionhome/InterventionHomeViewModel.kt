package me.bertilfrigaard.tether.ui.screens.intervention.interventionhome

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class InterventionHomeUiState(
    val test: String = "Default Value"
)

class InterventionHomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(InterventionHomeUiState())
    val uiState: StateFlow<InterventionHomeUiState> = _uiState.asStateFlow()

    fun updateTest(test: String) {
        _uiState.update { it.copy(test = test) }
    }
}


