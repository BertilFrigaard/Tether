package me.bertilfrigaard.tether.nav.main

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface MainNavKey : NavKey

@Serializable
data object Home : MainNavKey

@Serializable
data object CreateBlock : MainNavKey {

    @Serializable
    data object SetupBlock : MainNavKey

    @Serializable
    data object SelectApps : MainNavKey
}