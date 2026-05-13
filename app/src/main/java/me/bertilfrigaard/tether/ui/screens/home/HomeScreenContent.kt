package me.bertilfrigaard.tether.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.bertilfrigaard.tether.R
import me.bertilfrigaard.tether.ui.components.ScreenContent
import me.bertilfrigaard.tether.ui.screens.home.components.ActionButton
import me.bertilfrigaard.tether.ui.screens.home.components.ActionButtonSurface
import me.bertilfrigaard.tether.ui.screens.home.components.HomeTopAppBar
import me.bertilfrigaard.tether.ui.theme.TetherPalette
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun HomeScreenContent(state: HomeUiState) {
    Scaffold(
        topBar = {
            HomeTopAppBar()
        }
    ) { innerPadding ->
        ScreenContent(modifier = Modifier.padding(innerPadding)) {
            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "ACTIONS",
                style = TetherTheme.typography.overline,
                color = TetherTheme.colors.ink2
            )

            Spacer(modifier = Modifier.height(10.dp))

            ActionButton(
                actionDrawable = R.drawable.add_24px,
                actionTitle = "Create new block",
                actionDescription = "Pick an app and set the rules"
            )

            Spacer(modifier = Modifier.height(10.dp))

            ActionButton(
                actionDrawable = R.drawable.abc_24px,
                actionTitle = "View blocks",
                actionDescription = "View or edit your blocks",
                style = ActionButtonSurface
            )

        }
    }
}

@Preview(showBackground = false)
@Composable
fun Preview() {
    TetherTheme { HomeScreenContent(HomeUiState("123")) }
}