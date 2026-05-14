package me.bertilfrigaard.tether.ui.screens.home.components

import android.graphics.drawable.Drawable
import android.widget.Button
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import me.bertilfrigaard.tether.R
import me.bertilfrigaard.tether.ui.theme.TetherTheme

interface ActionButtonStyle {
    val containerColor: Color
        @Composable @ReadOnlyComposable get

    val iconContainerColor: Color
        @Composable @ReadOnlyComposable get
    val iconTint: Color
        @Composable @ReadOnlyComposable get

    val textTitleColor: Color
        @Composable @ReadOnlyComposable get
    val textDescriptionColor: Color
        @Composable @ReadOnlyComposable get

    val border: BorderStroke?
        @Composable @ReadOnlyComposable get
}

data object ActionButtonPrimary : ActionButtonStyle {
    override val containerColor: Color
        @Composable @ReadOnlyComposable get() = TetherTheme.colors.accent

    override val iconContainerColor: Color
        @Composable @ReadOnlyComposable get() = TetherTheme.colors.accentMedium
    override val iconTint: Color
        @Composable @ReadOnlyComposable get() = TetherTheme.colors.accentInk

    override val textTitleColor: Color
        @Composable @ReadOnlyComposable get() = TetherTheme.colors.accentInk
    override val textDescriptionColor: Color
        @Composable @ReadOnlyComposable get() = TetherTheme.colors.ink4

    override val border: BorderStroke?
        @Composable @ReadOnlyComposable get() = null
}

data object ActionButtonSurface : ActionButtonStyle {
    override val containerColor: Color
        @Composable @ReadOnlyComposable get() = TetherTheme.colors.surface

    override val iconContainerColor: Color
        @Composable @ReadOnlyComposable get() = TetherTheme.colors.bg
    override val iconTint: Color
        @Composable @ReadOnlyComposable get() = TetherTheme.colors.ink

    override val textTitleColor: Color
        @Composable @ReadOnlyComposable get() = TetherTheme.colors.ink
    override val textDescriptionColor: Color
        @Composable @ReadOnlyComposable get() = TetherTheme.colors.ink2

    override val border: BorderStroke
        @Composable @ReadOnlyComposable get() = BorderStroke(1.dp, TetherTheme.colors.hairline)
}

@Composable
fun ActionButton(
    @DrawableRes actionDrawable: Int,
    actionTitle: String,
    actionDescription: String,
    style: ActionButtonStyle = ActionButtonPrimary,
    onClick: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = style.containerColor),
        border = style.border,
        shape = RoundedCornerShape(20),
        onClick = onClick
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ) {
            Icon(
                painter = painterResource(actionDrawable),
                contentDescription = "View blocks icon",
                tint = style.iconTint,
                modifier = Modifier
                    .size(38.dp)
                    .clip(RoundedCornerShape(25))
                    .background(style.iconContainerColor)
                    .padding(6.dp)
            )
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(
                    text = actionTitle,
                    style = TetherTheme.typography.bodyEmphasis,
                    color = style.textTitleColor
                )
                Text(
                    text = actionDescription,
                    style = TetherTheme.typography.body,
                    color = style.textDescriptionColor
                )
            }
            Spacer(Modifier.weight(1f))
            Icon(
                painter = painterResource(R.drawable.arrow_forward_24px),
                contentDescription = "Create new block icon",
                tint = style.iconTint,
                modifier = Modifier
                    .size(20.dp)
            )
        }
    }
}