package me.bertilfrigaard.tether.ui.components.input

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun StepperInput(value: Int, setValue: (Int) -> Unit, min: Int? = null, max: Int? = null) {
    val rowShape = RoundedCornerShape(8.dp)
    Row(
        modifier = Modifier
            .clip(rowShape)
            .border(
                BorderStroke(
                    1.dp, TetherTheme.colors.hairline
                ), rowShape
            )
            .background(TetherTheme.colors.surface2)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        StepperButton(
            "-", TetherTheme.colors.surface2, TetherTheme.colors.ink
        ) { if (value > (min ?: Int.MIN_VALUE)) setValue(value - 1) }

        Text(
            modifier = Modifier.padding(horizontal = 6.dp), text = value.toString()
        )

        StepperButton(
            "+", TetherTheme.colors.ink, TetherTheme.colors.accentInk
        ) { if (value < (max ?: Int.MAX_VALUE)) setValue(value + 1) }
    }
}

// If this needs to be used in other files, extract StepperButton to its own file
@Composable
private fun StepperButton(
    label: String,
    containerColor: Color,
    contentColor: Color,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .size(28.dp)
            .clip(RoundedCornerShape(7.dp))
            .background(containerColor)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = label,
            color = contentColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}