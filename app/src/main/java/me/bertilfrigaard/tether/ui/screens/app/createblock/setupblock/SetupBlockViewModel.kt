package me.bertilfrigaard.tether.ui.screens.app.createblock.setupblock

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import me.bertilfrigaard.tether.data.model.BlockCondition
import kotlin.math.max

data class SetupBlockUiState(
    val selectedCondition: BlockCondition = BlockCondition.ON_FIRST_OPEN,
    val dailyUsage: Int = 10,

    val allowPass: Boolean = false,
    val delayPassGrant: Int = 20,
    val maxPassLength: Int = 30,
    val passCooldown: Int = 60,

    val name: String = ""
)

class SetupBlockViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(SetupBlockUiState())
    val uiState: StateFlow<SetupBlockUiState> = _uiState.asStateFlow()

    fun setSelectedCondition(condition: BlockCondition) {
        _uiState.update { it.copy(selectedCondition = condition) }
    }

    fun setDailyUsage(usage: Int) {
        _uiState.update { it.copy(dailyUsage = max(usage, 0)) }
    }

    fun setAllowPass(allow: Boolean) {
        _uiState.update { it.copy(allowPass = allow) }
    }

    fun setDelayPassGrant(delay: Int) {
        _uiState.update { it.copy(delayPassGrant = max(delay, 0)) }
    }

    fun setMaxPassLength(length: Int) {
        _uiState.update { it.copy(maxPassLength = max(length, 0)) }
    }

    fun setPassCooldown(cooldown: Int) {
        _uiState.update { it.copy(passCooldown = max(cooldown, 0)) }
    }

    fun setName(name: String) {
        _uiState.update { it.copy(name = name) }
    }
}
