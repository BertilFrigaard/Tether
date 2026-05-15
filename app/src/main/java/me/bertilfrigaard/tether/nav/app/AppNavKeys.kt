package me.bertilfrigaard.tether.nav.app

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface AppNavKey : NavKey

@Serializable
data object Home : AppNavKey

@Serializable
data object ViewBlocks : AppNavKey

@Serializable
data object Settings : AppNavKey

@Serializable
data object CreateBlock : AppNavKey {

    @Serializable
    data object SetupBlock : AppNavKey

    @Serializable
    data object SelectApps : AppNavKey
}