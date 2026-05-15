package me.bertilfrigaard.tether.ui.screens.app.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun HomeTopAppBar(goToSettings: () -> Unit) {
    TopAppBar(
        title = {
            Row() {
                Text(
                    text = "Tether",
                    style = TetherTheme.typography.wordmark,
                    color = TetherTheme.colors.ink
                )
                Text(
                    text = "V0.1",
                    style = TetherTheme.typography.overline,
                    color = TetherTheme.colors.ink3,
                    modifier = Modifier
                        .padding(start = 6.dp, bottom = 4.dp)
                        .align(Alignment.Bottom)
                )
            }
        },
        actions = {
            IconButton(
                modifier = Modifier.offset(x = (-8).dp),
                onClick = goToSettings
            ) {
                Icon(
                    painter = painterResource(R.drawable.settings_24px),
                    contentDescription = "Settings",
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(TetherTheme.colors.surface2)
                        .padding(6.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = TetherTheme.colors.bg
        )
    )
}