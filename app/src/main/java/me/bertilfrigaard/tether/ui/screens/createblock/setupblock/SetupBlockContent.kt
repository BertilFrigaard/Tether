package me.bertilfrigaard.tether.ui.screens.createblock.setupblock

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.bertilfrigaard.tether.ui.components.PageTopAppBar
import me.bertilfrigaard.tether.ui.components.ScreenContent
import me.bertilfrigaard.tether.ui.screens.createblock.setupblock.components.AppsSelector
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun SetupBlockContent(state: SetupBlockUiState, goBack: () -> Unit, goToSelectApps: () -> Unit) {
    Scaffold(
        topBar = {
            PageTopAppBar(title = "Setup block", onBack = goBack)
        }
    ) { innerPadding ->
        ScreenContent(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = "What should we tether down?",
                style = TetherTheme.typography.display,
                color = TetherTheme.colors.ink
            )

            Spacer(Modifier.height(10.dp))

            Text(
                text = "APP SELECTION",
                style = TetherTheme.typography.overline,
                color = TetherTheme.colors.ink2
            )

            Spacer(Modifier.height(8.dp))

            AppsSelector(
                selectedApps = null,
                onChangeSelection = goToSelectApps
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun Preview() {
    TetherTheme { SetupBlockContent(SetupBlockUiState(), goBack = {}, goToSelectApps = {}) }
}