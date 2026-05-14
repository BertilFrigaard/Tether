package me.bertilfrigaard.tether.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import me.bertilfrigaard.tether.R
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageTopAppBar(title: String? = null, onBack: (() -> Unit)? = null) {
    TopAppBar(
        title = {
            if (title != null) {
                Row {
                    Text(
                        text = title,
                        style = TetherTheme.typography.title,
                        color = TetherTheme.colors.ink
                    )
                }
            }
        },
        navigationIcon = {
            if (onBack != null) {
                IconButton(
                    onClick = onBack
                ) {
                    Icon(
                        painter = painterResource(R.drawable.arrow_back_24px),
                        contentDescription = "Go back",
                        modifier = Modifier
                            .size(20.dp)
                    )
                }

            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = TetherTheme.colors.bg
        )
    )
}