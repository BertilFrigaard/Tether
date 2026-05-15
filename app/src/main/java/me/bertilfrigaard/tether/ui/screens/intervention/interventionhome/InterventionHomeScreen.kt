package me.bertilfrigaard.tether.ui.screens.intervention.interventionhome

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun InterventionHomeScreen(vm: InterventionHomeViewModel) {
    val state by vm.uiState.collectAsStateWithLifecycle()
    InterventionHomeContent(state)
}