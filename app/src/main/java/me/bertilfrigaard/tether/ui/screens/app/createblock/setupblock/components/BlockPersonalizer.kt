package me.bertilfrigaard.tether.ui.screens.app.createblock.setupblock.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import me.bertilfrigaard.tether.R
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun BlockPersonalizer() {
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = TetherTheme.colors.surface),
        border = BorderStroke(1.dp, TetherTheme.colors.hairline),
        shape = RoundedCornerShape(20),
        onClick = {}
    ) {
        Column() {
            Text(
                text = "Personalize",
                style = TetherTheme.typography.bodyEmphasis,
                color = TetherTheme.colors.ink
            )
            Text(
                text = "Click to expand",
                style = TetherTheme.typography.body,
                color = TetherTheme.colors.ink2
            )
        }
        Spacer(Modifier.weight(1f))
        Icon(
            painter = painterResource(R.drawable.arrow_down_24px),
            contentDescription = "Expand personalizer icon",
            tint = TetherTheme.colors.ink,
            modifier = Modifier
                .size(20.dp)
        )
    }
}