package me.bertilfrigaard.tether.ui.screens.viewblocks

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.bertilfrigaard.tether.MainApplication
import me.bertilfrigaard.tether.data.model.Block

data class ViewBlocksUiState(
    val blocks: List<Block> = emptyList()
)

class ViewBlocksViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ViewBlocksUiState())
    val uiState: StateFlow<ViewBlocksUiState> = _uiState.asStateFlow()
    private val blockRepository = MainApplication.instance.blockRepository

    init {
        viewModelScope.launch {
            blockRepository.observeBlocks()
                .collect { blocks -> _uiState.update { it.copy(blocks = blocks) } }
        }
    }
}