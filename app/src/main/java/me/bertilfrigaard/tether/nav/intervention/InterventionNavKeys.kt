package me.bertilfrigaard.tether.nav.intervention

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface InterventionNavKey : NavKey

@Serializable
data object InterventionHome : InterventionNavKey