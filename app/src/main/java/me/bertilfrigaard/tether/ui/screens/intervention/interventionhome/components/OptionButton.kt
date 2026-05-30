package me.bertilfrigaard.tether.ui.screens.intervention.interventionhome.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import me.bertilfrigaard.tether.R
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun OptionButton(title: String, description: String, onClick: (() -> Unit)? = null, disabled: Boolean = false) {
    var modifier = Modifier
        .padding(horizontal = 20.dp)
        .padding(bottom = 25.dp)
        .clip(RoundedCornerShape(16.dp))
        .background(if (disabled) TetherTheme.colors.bg else TetherTheme.colors.surface)
        .border(
            BorderStroke(1.dp, TetherTheme.colors.hairline),
            RoundedCornerShape(16.dp)
        )
    if (onClick != null) {
        modifier = modifier.clickable(
            onClick =  onClick
        )
    }
    modifier = modifier.padding(horizontal = 35.dp, vertical = 14.dp)

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = TetherTheme.typography.bodyEmphasis,
                color = if (disabled) TetherTheme.colors.ink2 else TetherTheme.colors.ink
            )
            Text(
                text = description,
                style = TetherTheme.typography.body,
                color = if (disabled) TetherTheme.colors.ink3 else TetherTheme.colors.ink2
            )
        }
        if(!disabled) {
            Icon(
                painter = painterResource(R.drawable.arrow_forward_24px),
                contentDescription = "Grant pass icon",
                tint = TetherTheme.colors.ink2
            )
        }
    }
}
//
//Column(
//modifier = Modifier
//.padding(horizontal = 20.dp)
//.padding(bottom = 25.dp)
//.clip(RoundedCornerShape(16.dp))
//.background(TetherTheme.colors.surface)
//.border(
//BorderStroke(1.dp, TetherTheme.colors.hairline),
//RoundedCornerShape(16.dp)
//)
//.padding(horizontal = 35.dp, vertical = 14.dp)
//) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.spacedBy(10.dp),
//        modifier = Modifier.clickable(
//            onClick = onGrantPass, indication = null, interactionSource = null
//        )
//    ) {
//        Column(modifier = Modifier.weight(1f)) {
//            Text(
//                text = "Grant a limited pass",
//                style = TetherTheme.typography.bodyEmphasis,
//                color = TetherTheme.colors.ink
//            )
//            Text(
//                text = "Let you use $appLabel for a limited time more. ",
//                style = TetherTheme.typography.body,
//                color = TetherTheme.colors.ink2
//            )
//        }
//        Icon(
//            painter = painterResource(R.drawable.arrow_forward_24px),
//            contentDescription = "Grant pass icon",
//            tint = TetherTheme.colors.ink2
//        )
//    }
//}