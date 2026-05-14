package me.bertilfrigaard.tether.ui.components.input

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import me.bertilfrigaard.tether.R
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun DropDown() {
    Row() {
        Text(
            text = "On first open",
            style = TetherTheme.typography.body,
            color = TetherTheme.colors.ink
        )
        Spacer(Modifier.weight(1f))
        Icon(
            painter = painterResource(R.drawable.arrow_down_24px),
            contentDescription = "Expand dropdown icon",
            tint = TetherTheme.colors.ink,
            modifier = Modifier
                .size(20.dp)
        )
    }
}