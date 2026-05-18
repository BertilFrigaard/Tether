package me.bertilfrigaard.tether.ui.screens.intervention.passdelay

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import me.bertilfrigaard.tether.ui.screens.intervention.InterventionUiState
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun PassDelayContent(
    sharedState: InterventionUiState, onGoHome: () -> Unit, onGoSetupPass: () -> Unit
) {

    var showConfirm by remember { mutableStateOf(false) }
    var timerStarted by remember { mutableStateOf(false) }

    LaunchedEffect(sharedState, showConfirm) {
        if (!timerStarted) {
            timerStarted = true
            delay((sharedState.block?.delayPassGrant?.toLong()?.times(1000L)) ?: 0L)
            showConfirm = true
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(TetherTheme.colors.bg)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "WAIT", style = TetherTheme.typography.bam, color = TetherTheme.colors.ink
            )
            Text(
                text = "Granting passes for this block has a delay of ${sharedState.block?.delayPassGrant} seconds. In due time you will be allowed to continue.",
                style = TetherTheme.typography.body,
                color = TetherTheme.colors.ink2,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 30.dp, vertical = 10.dp)
            )
            Button(
                onClick = onGoHome,
                contentPadding = PaddingValues(vertical = 20.dp),
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 10.dp)
            ) {
                Text(
                    text = "Cancel & close",
                    style = TetherTheme.typography.bigButton,
                    color = TetherTheme.colors.accentInk
                )
            }
            if (showConfirm) {
                Spacer(Modifier.height(8.dp))
                Text(
                    text = "Setup pass", modifier = Modifier.clickable(
                        onClick = onGoSetupPass, indication = null, interactionSource = null
                    ), style = TetherTheme.typography.bodyEmphasis, color = TetherTheme.colors.ink2
                )
            }
        }
    }
}