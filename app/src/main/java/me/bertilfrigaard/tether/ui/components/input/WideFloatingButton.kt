package me.bertilfrigaard.tether.ui.components.input

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun WideFloatingButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 16.dp)
            .shadow(
                elevation = 12.dp,
                shape = CircleShape,
                ambientColor = Color.Black.copy(alpha = 0.18f),
                spotColor = Color.Black.copy(alpha = 0.18f),
            )
            .then(modifier),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = TetherTheme.colors.accent,
            contentColor = TetherTheme.colors.accentInk,
        ),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 15.dp),
    ) {
        Text(
            text = text,
            style = TetherTheme.typography.button,
        )
    }
}