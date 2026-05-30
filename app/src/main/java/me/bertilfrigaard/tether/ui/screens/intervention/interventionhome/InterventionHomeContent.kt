package me.bertilfrigaard.tether.ui.screens.intervention.interventionhome

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import me.bertilfrigaard.tether.R
import me.bertilfrigaard.tether.data.model.BlockCondition
import me.bertilfrigaard.tether.ui.screens.intervention.InterventionUiState
import me.bertilfrigaard.tether.ui.screens.intervention.interventionhome.components.OptionButton
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun InterventionHomeContent(
    sharedState: InterventionUiState, onGoHome: () -> Unit, onGrantPass: () -> Unit
) {
    var optionsExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(TetherTheme.colors.bg)
            .padding(top = 75.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "STOP", style = TetherTheme.typography.bam, color = TetherTheme.colors.ink
        )

        if (!sharedState.isLoading) {
            val appLabel = sharedState.appInfo?.appLabel ?: "Unknown"
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .clip(CircleShape)
                    .background(TetherTheme.colors.surface)
                    .padding(vertical = 10.dp, horizontal = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(25))
                        .background(TetherTheme.colors.surface2)
                        .padding(6.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = appLabel.firstOrNull().toString(),
                        style = TetherTheme.typography.bodyEmphasis,
                        color = TetherTheme.colors.ink
                    )
                }
                Spacer(Modifier.width(4.dp))
                Text(
                    text = appLabel,
                    style = TetherTheme.typography.bodyEmphasis,
                    color = TetherTheme.colors.ink
                )
                Spacer(Modifier.width(6.dp))
                VerticalDivider(modifier = Modifier.padding(vertical = 8.dp))
                Spacer(Modifier.width(6.dp))
                val reasonText = when (sharedState.block?.blockCondition) {
                    BlockCondition.AFTER_DAILY_USAGE_LIMIT -> {
                        "Daily limit reached"
                    }

                    BlockCondition.ON_FIRST_OPEN -> {
                        "App is blocked"
                    }

                    else -> {
                        "Unknown reason"
                    }
                }
                Text(
                    text = reasonText,
                    style = TetherTheme.typography.body,
                    color = TetherTheme.colors.ink2
                )
            }
            Text( // TODO: This should be replaced with something else, maybe a random quote
                modifier = Modifier.padding(horizontal = 40.dp, vertical = 10.dp),
                text = "You set this limit because mornings were getting eaten. You're already 18 of 30 minutes in.",
                style = TetherTheme.typography.body,
                color = TetherTheme.colors.ink2,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.weight(1f))

            Button(
                onClick = onGoHome,
                contentPadding = PaddingValues(vertical = 20.dp),
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Text(
                    text = "Accept & Close",
                    style = TetherTheme.typography.bigButton,
                    color = TetherTheme.colors.accentInk
                )
            }
            Spacer(Modifier.height(4.dp))
            Text(
                text = "Returns you to the home screen.",
                style = TetherTheme.typography.caption,
                color = TetherTheme.colors.ink2
            )
            if (sharedState.block?.allowPass == true) {
                Row(
                    modifier = Modifier
                        .clickable(
                            onClick = { optionsExpanded = !optionsExpanded },
                            indication = null,
                            interactionSource = null
                        )
                        .padding(
                            if (optionsExpanded) {
                                PaddingValues(vertical = 20.dp)
                            } else {
                                PaddingValues(vertical = 40.dp)
                            }
                        )
                ) {
                    Text(
                        text = "Other options",
                        style = TetherTheme.typography.bodyEmphasis,
                        color = TetherTheme.colors.ink3
                    )
                    Spacer(Modifier.width(5.dp))
                    Icon(
                        painter = painterResource(
                            if (optionsExpanded) {
                                R.drawable.arrow_up_24px
                            } else {
                                R.drawable.arrow_down_24px
                            }
                        ),
                        contentDescription = "Expand options icon",
                        tint = TetherTheme.colors.ink3,
                        modifier = Modifier.size(20.dp)
                    )
                }
            } else {
                Spacer(Modifier.height(40.dp))
            }
            if (optionsExpanded) {
                val now = System.currentTimeMillis()
                val passOnCooldown = sharedState.latestPass?.let {
                    it.createdAt + ((sharedState.block?.passCooldown?.times(60)?.times(1000)) ?: 0) >= now
                } == true

                if (sharedState.block?.allowPass != true) {
                    OptionButton(
                        "Grant a limited pass",
                        "You can not grant passes for $appLabel.",
                        disabled = true
                    )
                } else if (passOnCooldown) {
                    OptionButton(
                        "Grant a limited pass",
                        "You recently granted a pass for $appLabel. Please wait before trying again.",
                        disabled = true
                    )
                } else {
                    OptionButton(
                        "Grant a limited pass",
                        "Let you use $appLabel for a limited time more.",
                        onGrantPass
                    )
                }
            }
        }
    }
}