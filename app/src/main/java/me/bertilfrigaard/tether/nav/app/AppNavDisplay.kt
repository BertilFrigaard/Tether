package me.bertilfrigaard.tether.nav.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import me.bertilfrigaard.tether.nav.popOneMinOne
import me.bertilfrigaard.tether.nav.pushMaxOne
import me.bertilfrigaard.tether.ui.screens.app.createblock.CreateBlockViewModel
import me.bertilfrigaard.tether.ui.screens.app.createblock.selectapps.SelectAppsScreen
import me.bertilfrigaard.tether.ui.screens.app.createblock.setupblock.SetupBlockScreen
import me.bertilfrigaard.tether.ui.screens.app.home.HomeScreen
import me.bertilfrigaard.tether.ui.screens.app.settings.SettingsScreen
import me.bertilfrigaard.tether.ui.screens.app.viewblocks.ViewBlocksScreen

@Composable
fun AppNavDisplay(modifier: Modifier = Modifier) {
    val rootBackStack = rememberNavBackStack(Home)

    NavDisplay(
        backStack = rootBackStack,
        modifier = modifier,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Home> {
                HomeScreen(
                    vm = viewModel(),
                    goToCreateBlock = { rootBackStack.pushMaxOne(CreateBlock) },
                    goToViewBlocks = { rootBackStack.pushMaxOne(ViewBlocks) },
                    goToSettings = { rootBackStack.pushMaxOne(Settings) }
                )
            }
            entry<ViewBlocks> {
                ViewBlocksScreen(
                    vm = viewModel()
                )
            }
            entry<Settings> {
                SettingsScreen(
                    vm = viewModel(),
                    goBack = { rootBackStack.popOneMinOne() }
                )
            }
            entry<CreateBlock> {
                val createBlockBackStack = rememberNavBackStack(CreateBlock.SetupBlock)
                val createBlockViewModel: CreateBlockViewModel = viewModel()

                NavDisplay(
                    backStack = createBlockBackStack,
                    entryDecorators = listOf(
                        rememberSaveableStateHolderNavEntryDecorator(),
                        rememberViewModelStoreNavEntryDecorator()
                    ),
                    entryProvider = entryProvider {
                        entry<CreateBlock.SetupBlock> {
                            SetupBlockScreen(
                                vm = viewModel(),
                                sharedVm = createBlockViewModel,
                                goBack = { rootBackStack.popOneMinOne() },
                                goToSelectApps = { createBlockBackStack.pushMaxOne(CreateBlock.SelectApps) })
                        }
                        entry<CreateBlock.SelectApps> {
                            SelectAppsScreen(
                                vm = viewModel(),
                                sharedVm = createBlockViewModel,
                                goBack = { createBlockBackStack.popOneMinOne() })
                        }
                    }
                )
            }
        }
    )
}