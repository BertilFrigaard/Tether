package me.bertilfrigaard.tether.ui.screens.app.createblock.selectapps

import android.graphics.drawable.Drawable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.bertilfrigaard.tether.MainApplication
import me.bertilfrigaard.tether.data.model.AppInfo

data class SelectAppsUiState(
    val searchQuery: String = "",
    val selectableApps: List<AppInfo> = emptyList(),
    val appIcons: Map<String, Drawable?> = emptyMap(),
    val selectedApps: List<AppInfo> = emptyList(),
    val loadingSelectableApps: Boolean = true
)

class SelectAppsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(SelectAppsUiState())
    val uiState: StateFlow<SelectAppsUiState> = _uiState.asStateFlow()

    private val installedAppsDataSource = MainApplication.instance.installedAppsDataSource
    private val blockRepository = MainApplication.instance.blockRepository
    private var blockedApps: Set<String> = emptySet()

    private val appIconsDataSource = MainApplication.instance.appIconsDataSource
    private var installedApps: List<AppInfo> = emptyList()

    init {
        viewModelScope.launch {
            blockRepository.observeBlocks()
                .map { blocks -> blocks.flatMap { it.packageNames }.toSet() }.collect {
                    blockedApps = it
                    updateSelectableApps()
                    _uiState.update { state -> state.copy(loadingSelectableApps = false) }
                }
        }

        viewModelScope.launch(Dispatchers.IO) {
            val apps = installedAppsDataSource.getLaunchableApps()
            installedApps = apps
            updateSelectableApps()

            for (app in apps) {
                launch {
                    val icon = appIconsDataSource.getIcon(app.packageName)
                    _uiState.update { it.copy(appIcons = it.appIcons + (app.packageName to icon)) }
                }
            }
        }
    }

    private fun updateSelectableApps() {
        _uiState.update {
            it.copy(selectableApps = installedApps.filter { app -> app.packageName !in blockedApps }
                .filter { app ->
                    app.appLabel.lowercase().contains(_uiState.value.searchQuery)
                }.sortedBy { app -> app.appLabel })
        }
    }

    fun updateSearchQuery(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
        updateSelectableApps()
    }

    fun setAppSelected(app: AppInfo, selected: Boolean) {
        if (selected) {
            _uiState.update { it.copy(selectedApps = it.selectedApps + app) }
        } else {
            _uiState.update { it.copy(selectedApps = it.selectedApps - app) }
        }
    }

    fun setSelectedApps(apps: List<AppInfo>) {
        _uiState.update { it.copy(selectedApps = apps) }
    }
}
