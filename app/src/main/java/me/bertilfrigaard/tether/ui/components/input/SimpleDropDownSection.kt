package me.bertilfrigaard.tether.ui.components.input

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import me.bertilfrigaard.tether.R
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun SimpleDropDownSection(
    label: String, description: String, expandedDescription: String? = null, sections: List<@Composable () -> Unit>
) {
    var isExpanded by remember { mutableStateOf(false) }
    val columnShape = RoundedCornerShape(14.dp)

    Column(
        modifier = Modifier
            .clip(columnShape)
            .background(TetherTheme.colors.surface)
            .border(BorderStroke(1.dp, TetherTheme.colors.hairline), columnShape)

    ) {
        Row(
            modifier = Modifier
                .clickable(
                    onClick = { isExpanded = !isExpanded },
                    indication = null,
                    interactionSource = null
                )
                .padding(
                    horizontal = ButtonDefaults.ContentPadding.calculateEndPadding(
                        LayoutDirection.Ltr
                    )
                )
                .padding(
                    if (isExpanded) {
                        PaddingValues(top = 16.dp)
                    } else {
                        PaddingValues(vertical = 16.dp)
                    }
                ), verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
                Text(
                    text = label,
                    style = TetherTheme.typography.bodyEmphasis,
                    color = TetherTheme.colors.ink
                )
                Text(
                    text = if (isExpanded && expandedDescription != null) {expandedDescription} else {description},
                    style = TetherTheme.typography.body,
                    color = TetherTheme.colors.ink2
                )
            }
            Spacer(Modifier.weight(1f))
            Icon(
                painter = painterResource(
                    if (isExpanded) {
                        R.drawable.arrow_up_24px
                    } else {
                        R.drawable.arrow_down_24px
                    }
                ),
                contentDescription = "Expand personalizer icon",
                tint = TetherTheme.colors.ink,
                modifier = Modifier.size(20.dp)
            )
        }
        if (isExpanded) {
            Column(
                modifier = Modifier
                    .padding(
                        horizontal = ButtonDefaults.ContentPadding.calculateEndPadding(
                            LayoutDirection.Ltr
                        )
                    )
                    .padding(bottom = 16.dp)
            ) {
                for (section in sections) {
                    HorizontalDivider(
                        color = TetherTheme.colors.hairline,
                        thickness = 1.dp,
                        modifier = Modifier.padding(vertical = 12.dp)
                    )
                    section()
                }
            }

        }
    }
}