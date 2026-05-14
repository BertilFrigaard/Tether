package me.bertilfrigaard.tether.ui.screens.createblock.setupblock.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun BlockPassSettings(
    allowPass: Boolean,
    setAllowPass: (Boolean) -> Unit,
    delayPassGrant: Int,
    setDelayPassGrant: (Int) -> Unit,
    maxPassLength: Int,
    setMaxPassLength: (Int) -> Unit,
    passCooldown: Int,
    setPassCooldown: (Int) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(if (allowPass) {3} else {10}))
            .background(TetherTheme.colors.surface)
            .padding(
                vertical = 16.dp, horizontal = ButtonDefaults.ContentPadding.calculateEndPadding(
                    LayoutDirection.Ltr
                )
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Allow Pass",
                    style = TetherTheme.typography.bodyEmphasis,
                    color = TetherTheme.colors.ink
                )
                Text(
                    text = "Allow granting a pass for this block",
                    style = TetherTheme.typography.body,
                    color = TetherTheme.colors.ink2
                )
            }
            Switch(
                checked = allowPass,
                onCheckedChange = setAllowPass,
                colors = SwitchDefaults.colors(
                    uncheckedBorderColor = Color.Transparent,
                    uncheckedTrackColor = TetherTheme.colors.surface2,
                    uncheckedThumbColor = TetherTheme.colors.surface
                )
            )
        }
        if (allowPass) {
            HorizontalDivider(
                color = TetherTheme.colors.hairline,
                thickness = 1.dp,
                modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
            )
            StepperSubSection(passCooldown, setPassCooldown, "Pass cooldown", "Minutes before another pass can be granted")
            HorizontalDivider(
                color = TetherTheme.colors.hairline,
                thickness = 1.dp,
                modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
            )
            StepperSubSection(delayPassGrant, setDelayPassGrant, "Delay pass grant", "Seconds before a pass is granted")
            HorizontalDivider(
                color = TetherTheme.colors.hairline,
                thickness = 1.dp,
                modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
            )
            StepperSubSection(maxPassLength, setMaxPassLength, "Max pass length", "Max length of a pass in minutes")
        }
    }
}