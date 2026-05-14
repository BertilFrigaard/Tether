package me.bertilfrigaard.tether.ui.screens.createblock.setupblock.components

import android.view.MenuItem
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import me.bertilfrigaard.tether.R
import me.bertilfrigaard.tether.data.model.BlockCondition
import me.bertilfrigaard.tether.ui.components.input.StepperInput
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun BlockConditionSettings(
    selectedCondition: BlockCondition,
    setSelectCondition: (BlockCondition) -> Unit,
    dailyUsage: Int,
    setDailyUsage: (Int) -> Unit
) {
    var showDropdown by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    if (selectedCondition == BlockCondition.AFTER_DAILY_USAGE_LIMIT) {
                        5
                    } else {
                        10
                    }
                )
            )
            .background(TetherTheme.colors.surface)
            .padding(
                vertical = 16.dp, horizontal = ButtonDefaults.ContentPadding.calculateEndPadding(
                    LayoutDirection.Ltr
                )
            )
    ) {
        Text(
            text = "Block condition",
            style = TetherTheme.typography.bodyEmphasis,
            color = TetherTheme.colors.ink
        )
        Text(
            text = "When should this block intervene?",
            style = TetherTheme.typography.body,
            color = TetherTheme.colors.ink2
        )

        Spacer(Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { showDropdown = !showDropdown })
                .clip(RoundedCornerShape(20))
                .background(TetherTheme.colors.surface2)
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Text(
                text = selectedCondition.label,
                style = TetherTheme.typography.body,
                color = TetherTheme.colors.ink
            )
            Spacer(Modifier.weight(1f))
            Icon(
                painter = painterResource(
                    if (showDropdown) {
                        R.drawable.arrow_up_24px
                    } else {
                        R.drawable.arrow_down_24px
                    }
                ),
                contentDescription = "Expand dropdown icon",
                tint = TetherTheme.colors.ink,
                modifier = Modifier
                    .size(20.dp)
            )
        }

        DropdownMenu(
            showDropdown,
            { showDropdown = false },
            containerColor = TetherTheme.colors.surface,
            border = BorderStroke(
                1.dp,
                TetherTheme.colors.hairline
            ),
            shape = RoundedCornerShape(15.dp),
            shadowElevation = 0.dp
        ) {
            for (condition in BlockCondition.entries) {
                DropdownMenuItem(
                    text = { Text(condition.label) },
                    onClick = {
                        setSelectCondition(condition)
                        showDropdown = false
                    }
                )
            }
        }

        if (selectedCondition == BlockCondition.AFTER_DAILY_USAGE_LIMIT) {
            HorizontalDivider(
                color = TetherTheme.colors.hairline,
                thickness = 1.dp,
                modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
            )
            StepperSubSection(
                dailyUsage,
                setDailyUsage,
                "Daily usage limit",
                "Minutes before first block intervention"
            )
        }
    }
}