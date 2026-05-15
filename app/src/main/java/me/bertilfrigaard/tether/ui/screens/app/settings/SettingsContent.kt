package me.bertilfrigaard.tether.ui.screens.app.settings

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.LifecycleResumeEffect
import me.bertilfrigaard.tether.ui.components.PageTopAppBar
import me.bertilfrigaard.tether.ui.components.ScreenContent
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun SettingsContent(
    state: SettingsUiState,
    goBack: () -> Unit,
    getOverlaySettingsIntent: () -> Intent,
    getNotificationSettingsIntent: () -> Intent,
    getUsageStatsSettingsIntent: () -> Intent
) {
    Scaffold(
        topBar = {
            PageTopAppBar(title = "Settings", onBack = goBack)
        }
    ) { innerPadding ->
        val context = LocalContext.current

        ScreenContent(modifier = Modifier.padding(innerPadding)) {
            Column() {
                Text(
                    text = "Permissions",
                    style = TetherTheme.typography.bodyEmphasis,
                    color = TetherTheme.colors.ink
                )
                Text(
                    text = "For Tether to work properly you need to grant all of the following permissions",
                    style = TetherTheme.typography.body,
                    color = TetherTheme.colors.ink2
                )
                Text(
                    text = "Overlay Permission: ${if (state.hasOverlayPermission) "Granted" else "Not granted"}",
                    style = TetherTheme.typography.bodyEmphasis,
                    color = TetherTheme.colors.ink
                )
                Button(
                    onClick = {
                        context.startActivity(getOverlaySettingsIntent())
                    }
                ) {
                    Text(
                        text = "Go to settings",
                        style = TetherTheme.typography.button,
                        color = TetherTheme.colors.ink
                    )
                }
                Text(
                    text = "Usage Permission: ${if (state.hasUsageStatsPermission) "Granted" else "Not granted"}",
                    style = TetherTheme.typography.bodyEmphasis,
                    color = TetherTheme.colors.ink
                )
                Button(
                    onClick = {
                        context.startActivity(getUsageStatsSettingsIntent())
                    }
                ) {
                    Text(
                        text = "Go to settings",
                        style = TetherTheme.typography.button,
                        color = TetherTheme.colors.ink
                    )
                }
                Text(
                    text = "Notification Permission: ${if (state.hasNotificationPermission) "Granted" else "Not granted"}",
                    style = TetherTheme.typography.bodyEmphasis,
                    color = TetherTheme.colors.ink
                )
                Button(
                    onClick = {
                        context.startActivity(getNotificationSettingsIntent())
                    }
                ) {
                    Text(
                        text = "Go to settings",
                        style = TetherTheme.typography.button,
                        color = TetherTheme.colors.ink
                    )
                }
            }
        }
    }
}