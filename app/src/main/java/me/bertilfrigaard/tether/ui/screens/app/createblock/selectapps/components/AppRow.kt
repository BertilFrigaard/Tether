package me.bertilfrigaard.tether.ui.screens.app.createblock.selectapps.components

import android.graphics.drawable.Drawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.bertilfrigaard.tether.data.model.AppInfo
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun AppRow(appInfo: AppInfo, icon: Drawable?, selected: Boolean, setSelected: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(20))
            .background(TetherTheme.colors.surface)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (icon == null) {
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(RoundedCornerShape(25))
                    .background(TetherTheme.colors.surface2)
                    .padding(6.dp),
                contentAlignment = Alignment.Center
            ) {
                if (appInfo.appLabel.isNotEmpty()) {
                    Text(
                        text = appInfo.appLabel[0].toString(),
                        style = TetherTheme.typography.bodyEmphasis,
                        color = TetherTheme.colors.ink
                    )
                }
            }
        } else {
            AsyncImage(
                model = icon,
                contentDescription = appInfo.appLabel + " icon",
                modifier = Modifier.size(40.dp)
            )
        }
        Spacer(Modifier.width(10.dp))
        Column() {
            Text(
                text = appInfo.appLabel,
                style = TetherTheme.typography.bodyEmphasis,
                color = TetherTheme.colors.ink
            )
            Text(
                text = "Tap switch to select",
                style = TetherTheme.typography.body,
                color = TetherTheme.colors.ink2
            )
        }
        Spacer(Modifier.weight(1f))
        Switch(
            selected,
            setSelected,
            colors = SwitchDefaults.colors(
                uncheckedBorderColor = Color.Transparent,
                uncheckedTrackColor = TetherTheme.colors.surface2,
                uncheckedThumbColor = TetherTheme.colors.surface
            )
        )
    }
}