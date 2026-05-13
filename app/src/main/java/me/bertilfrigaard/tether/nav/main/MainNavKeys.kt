package me.bertilfrigaard.tether.nav.main

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface MainNavKey : NavKey

@Serializable
data object Home : MainNavKey