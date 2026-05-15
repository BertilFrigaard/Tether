package me.bertilfrigaard.tether.nav.intervention

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import me.bertilfrigaard.tether.nav.main.Home
import me.bertilfrigaard.tether.ui.screens.home.HomeScreen
import me.bertilfrigaard.tether.ui.screens.intervention.interventionhome.InterventionHomeScreen

@Composable
fun InterventionNavDisplay(modifier: Modifier = Modifier) {
    val rootBackStack = rememberNavBackStack(InterventionHome)

    NavDisplay(
        backStack = rootBackStack,
        modifier = modifier,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<InterventionHome> {
                InterventionHomeScreen(
                    vm = viewModel()
                )
            }
        }
    )
}