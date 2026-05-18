package me.bertilfrigaard.tether.ui.screens.intervention.setuppass

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import me.bertilfrigaard.tether.ui.components.input.StepperInput
import me.bertilfrigaard.tether.ui.screens.intervention.InterventionUiState
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun SetupPassContent(
    sharedState: InterventionUiState,
    onGoHome: () -> Unit,
    setPassLength: (Int) -> Unit,
    createPass: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(TetherTheme.colors.bg),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(30.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Setup Pass",
                style = TetherTheme.typography.display,
                color = TetherTheme.colors.ink
            )
            Spacer(Modifier.height(14.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(TetherTheme.colors.surface)
                    .border(
                        BorderStroke(1.dp, TetherTheme.colors.hairline), RoundedCornerShape(10.dp)
                    )
                    .padding(
                        vertical = 16.dp,
                        horizontal = ButtonDefaults.ContentPadding.calculateEndPadding(
                            LayoutDirection.Ltr
                        )
                    )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Pass length",
                            style = TetherTheme.typography.bodyEmphasis,
                            color = TetherTheme.colors.ink
                        )
                        Text(
                            text = "How long should this pass grant access to ${sharedState.appInfo?.appLabel ?: "Unknown"} in minutes.",
                            style = TetherTheme.typography.body,
                            color = TetherTheme.colors.ink2
                        )
                    }
                    StepperInput(sharedState.passLengthMin, setPassLength)
                }
                HorizontalDivider(
                    color = TetherTheme.colors.hairline, modifier = Modifier.padding(14.dp)
                )
                Button(
                    onClick = onGoHome,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Regret & close",
                        style = TetherTheme.typography.button,
                        color = TetherTheme.colors.accentInk
                    )
                }
                Button(
                    onClick = createPass,
                    colors = ButtonDefaults.buttonColors(containerColor = TetherTheme.colors.surface2),
                    modifier = Modifier.fillMaxWidth(),
                    border = BorderStroke(1.dp, TetherTheme.colors.hairline),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Confirm",
                        style = TetherTheme.typography.button,
                        color = TetherTheme.colors.ink2
                    )
                }
            }
        }
//            Text(text = "Setup pass")
//            StepperInput(sharedState.passLengthMin, setPassLength)
//            Button(onClick = onGoHome) {
//                Text(text = "Regret & Go home")
//            }
//            Button(onClick = createPass) {
//                Text(text = "Confirm & Create")
//            }
//        }
    }
}