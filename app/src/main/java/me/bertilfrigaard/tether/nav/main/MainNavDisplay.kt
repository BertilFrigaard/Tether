package me.bertilfrigaard.tether.nav.main

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import me.bertilfrigaard.tether.ui.screens.createblock.selectapps.SelectAppsScreen
import me.bertilfrigaard.tether.ui.screens.createblock.setupblock.SetupBlockScreen
import me.bertilfrigaard.tether.ui.screens.home.HomeScreen

@Composable
fun MainNavDisplay(modifier: Modifier = Modifier) {
    val rootBackStack = rememberNavBackStack(Home)

    NavDisplay(
        backStack = rootBackStack,
        modifier = modifier,
        entryProvider = entryProvider {
            entry<Home> {
                HomeScreen(
                    vm = viewModel(),
                    goToCreateBlock = { rootBackStack.pushMaxOne(CreateBlock) })
            }
            entry<CreateBlock> {
                val createBlockBackStack = rememberNavBackStack(CreateBlock.SetupBlock)

                NavDisplay(
                    backStack = createBlockBackStack,
                    entryProvider = entryProvider {
                        entry<CreateBlock.SetupBlock> {
                            SetupBlockScreen(
                                vm = viewModel(),
                                goBack = { rootBackStack.popOneMinOne() },
                                goToSelectApps = { createBlockBackStack.pushMaxOne(CreateBlock.SelectApps) })
                        }
                        entry<CreateBlock.SelectApps> {
                            SelectAppsScreen(
                                vm = viewModel(),
                                goBack = { createBlockBackStack.popOneMinOne() })
                        }
                    }
                )
            }
        }
    )
}

private fun <T : NavKey> NavBackStack<T>.pushMaxOne(route: T) {
    if (lastOrNull() != route) add(route)
}

private fun <T : NavKey> NavBackStack<T>.popOneMinOne() {
    if (size > 1) removeLastOrNull()
}