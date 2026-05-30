package me.bertilfrigaard.tether.ui.screens.intervention

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
import me.bertilfrigaard.tether.data.model.BlockPass

data class InterventionUiState(
    val isLoading: Boolean = true,
    val appInfo: AppInfo? = null,
    val block: Block? = null,
    val latestPass: BlockPass? = null,
    val passLength: Int = 5
)

class InterventionViewModel(private val pkg: String) : ViewModel() {
    private val _uiState = MutableStateFlow(InterventionUiState())
    val uiState: StateFlow<InterventionUiState> = _uiState.asStateFlow()

    private val appsDataSource = MainApplication.instance.installedAppsDataSource
    private val blockRepository = MainApplication.instance.blockRepository

    init {
        viewModelScope.launch {
            val app = appsDataSource.getApp(pkg)
            val block = blockRepository.getBlock(pkg)
            val latestPass = blockRepository.getLatestBlockPass(pkg)
            _uiState.value = InterventionUiState(
                isLoading = false,
                appInfo = app,
                block = block,
                latestPass = latestPass
            )
        }
    }

    fun setPassLength(length: Int) {
        _uiState.value = _uiState.value.copy(passLength = length)
    }

    fun createPass(cbk: () -> Unit) {
        uiState.value.appInfo?.let {
            _uiState.update { state -> state.copy(isLoading = true) }
            val expiryMs = System.currentTimeMillis() + uiState.value.passLength * 60 * 1000
            viewModelScope.launch {
                blockRepository.createBlockPass(it.packageName, expiryMs)
                cbk()
                _uiState.update { state -> state.copy(isLoading = false) }
            }
        }
    }
}
