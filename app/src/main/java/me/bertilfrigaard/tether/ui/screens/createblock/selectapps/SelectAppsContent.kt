package me.bertilfrigaard.tether.ui.screens.createblock.selectapps

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.bertilfrigaard.tether.data.model.AppInfo
import me.bertilfrigaard.tether.ui.components.PageTopAppBar
import me.bertilfrigaard.tether.ui.components.ScreenContent
import me.bertilfrigaard.tether.ui.components.input.SearchBar
import me.bertilfrigaard.tether.ui.components.input.WideFloatingButton
import me.bertilfrigaard.tether.ui.screens.createblock.selectapps.components.AppRow
import me.bertilfrigaard.tether.ui.screens.createblock.setupblock.SetupBlockContent
import me.bertilfrigaard.tether.ui.screens.createblock.setupblock.SetupBlockUiState
import me.bertilfrigaard.tether.ui.screens.createblock.setupblock.components.AppsSelector
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun SelectAppsContent(
    state: SelectAppsUiState,
    setSelected: (AppInfo, Boolean) -> Unit,
    updateSearchQuery: (String) -> Unit,
    goBack: () -> Unit,
    confirmSelection: () -> Unit
) {
    Scaffold(
        topBar = {
            PageTopAppBar(title = "Select apps", onBack = goBack)
        }
    ) { innerPadding ->
        ScreenContent(modifier = Modifier.padding(innerPadding)) {

            SearchBar(state.searchQuery, updateSearchQuery)

            Box(modifier = Modifier.fillMaxSize()) {
                if (state.loadingSelectableApps) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) { CircularProgressIndicator() }
                } else {
                    LazyColumn(
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        items(state.selectableApps, key = { it.packageName }) {
                            val icon = state.appIcons[it.packageName]
                            AppRow(
                                it,
                                icon,
                                state.selectedApps.contains(it),
                                setSelected = { selected -> setSelected(it, selected) })
                        }
                        item { Spacer(Modifier.height(100.dp)) }
                    }
                }

                WideFloatingButton(
                    text = "Select ${state.selectedApps.size} apps",
                    onClick = confirmSelection,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(vertical = 16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun Preview() {
    TetherTheme {
        SelectAppsContent(
            SelectAppsUiState(
                loadingSelectableApps = false, selectableApps = listOf(
                    AppInfo("123", "Google")
                ),
                appIcons = mapOf("123" to null)
            ),
            updateSearchQuery = {},
            setSelected = { a, b -> },
            goBack = {},
            confirmSelection = {}
        )
    }
}