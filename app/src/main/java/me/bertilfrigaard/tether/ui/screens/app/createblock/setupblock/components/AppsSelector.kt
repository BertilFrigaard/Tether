package me.bertilfrigaard.tether.ui.screens.app.createblock.setupblock.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.bertilfrigaard.tether.R
import me.bertilfrigaard.tether.data.model.AppInfo
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun AppsSelector(selectedApps: List<AppInfo>, blockName: String, onChangeSelection: () -> Unit) {
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = TetherTheme.colors.surface),
        border = BorderStroke(1.dp, TetherTheme.colors.hairline),
        shape = RoundedCornerShape(20),
        onClick = onChangeSelection
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ) {
            if (selectedApps.size == 1) {
                AsyncImage(
                    model = null,
                    contentDescription = selectedApps[0].appLabel + " icon",
                    modifier = Modifier.size(40.dp)
                )
            } else if (selectedApps.size > 1) {
                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .clip(RoundedCornerShape(25))
                        .background(TetherTheme.colors.surface2)
                        .padding(6.dp),
                    contentAlignment = Alignment.Center
                ) {
                    if (blockName.isNotEmpty()) {
                        Text(
                            text = blockName[0].toString(),
                            style = TetherTheme.typography.bodyEmphasis,
                            color = TetherTheme.colors.ink
                        )
                    }
                }
            }
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(
                    text = if (selectedApps.isEmpty()) {
                        "No apps selected"
                    } else if (selectedApps.size == 1) {
                        "${selectedApps[0].appLabel} selected"
                    } else {
                        "${selectedApps.size} apps selected"
                    },
                    style = TetherTheme.typography.bodyEmphasis,
                    color = TetherTheme.colors.ink
                )
                Text(
                    text = if (selectedApps.isEmpty()) {
                        "Tap to select"
                    } else {
                        "Tap to change selection"
                    },
                    style = TetherTheme.typography.body,
                    color = TetherTheme.colors.ink2
                )
            }
            Spacer(Modifier.weight(1f))
            Icon(
                painter = painterResource(R.drawable.arrow_forward_24px),
                contentDescription = "Select apps icon",
                tint = TetherTheme.colors.ink,
                modifier = Modifier
                    .size(20.dp)
            )
        }
    }
}
