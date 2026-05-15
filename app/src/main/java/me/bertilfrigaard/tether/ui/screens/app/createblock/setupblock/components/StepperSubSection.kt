package me.bertilfrigaard.tether.ui.screens.app.createblock.setupblock.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.bertilfrigaard.tether.ui.components.input.StepperInput
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun StepperSubSection(value: Int, setValue: (Int) -> Unit, label: String, description: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.padding(end = 8.dp).weight(1f)) {
            Text(
                text = label,
                style = TetherTheme.typography.bodyEmphasis,
                color = TetherTheme.colors.ink
            )
            Text(
                text = description,
                style = TetherTheme.typography.body,
                color = TetherTheme.colors.ink2
            )
        }
        StepperInput(value, setValue)
    }
}