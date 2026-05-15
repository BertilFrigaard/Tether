package me.bertilfrigaard.tether.ui.screens.app.createblock.setupblock.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import me.bertilfrigaard.tether.R
import me.bertilfrigaard.tether.ui.components.input.SimpleDropDownSection
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun BlockPersonalizer(name: String, setName: (String) -> Unit) {
    SimpleDropDownSection(
        label = "Personalize",
        description = "Click to expand",
        expandedDescription = "Click to minimize",
        listOf(
            {
                Text(
                    text = "Block name",
                    style = TetherTheme.typography.bodyEmphasis,
                    color = TetherTheme.colors.ink
                )
                Text(
                    text = "This name will be used to identify this block",
                    style = TetherTheme.typography.body,
                    color = TetherTheme.colors.ink2
                )
                BasicTextField(
                    name,
                    setName,
                    singleLine = true,
                    cursorBrush = SolidColor(TetherTheme.colors.accent),
                    textStyle = TetherTheme.typography.body,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(5.dp))
                        .background(TetherTheme.colors.surface2)
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                )
            })
    )
}