package me.bertilfrigaard.tether.nav.intervention

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import me.bertilfrigaard.tether.nav.pushMaxOne
import me.bertilfrigaard.tether.ui.screens.intervention.InterventionViewModel
import me.bertilfrigaard.tether.ui.screens.intervention.interventionhome.InterventionHomeScreen
import me.bertilfrigaard.tether.ui.screens.intervention.passdelay.PassDelayScreen
import me.bertilfrigaard.tether.ui.screens.intervention.setuppass.SetupPassScreen

@Composable
fun InterventionNavDisplay(modifier: Modifier = Modifier, pkg: String, onFinished: () -> Unit) {
    val rootBackStack = rememberNavBackStack(InterventionHome)
    val interventionViewModel: InterventionViewModel = viewModel(factory = viewModelFactory {
        initializer {
            InterventionViewModel(
                pkg
            )
        }
    })

    NavDisplay(
        backStack = rootBackStack, modifier = modifier, entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ), entryProvider = entryProvider {
            entry<InterventionHome> {
                InterventionHomeScreen(
                    sharedVm = interventionViewModel,
                    onFinished = onFinished,
                    goToPassDelay = { rootBackStack.pushMaxOne(PassDelay) })
            }
            entry<PassDelay> {
                PassDelayScreen(
                    sharedVm = interventionViewModel, onFinished = onFinished, onGoSetupPass = {
                        rootBackStack.pushMaxOne(
                            SetupPass
                        )
                    })
            }
            entry<SetupPass> {
                SetupPassScreen(sharedVm = interventionViewModel, onFinished = onFinished)
            }
        })
}