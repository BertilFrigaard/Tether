package me.bertilfrigaard.tether.ui.screens.createblock.setupblock

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.bertilfrigaard.tether.ui.components.PageTopAppBar
import me.bertilfrigaard.tether.ui.components.ScreenContent
import me.bertilfrigaard.tether.ui.screens.createblock.CreateBlockUiState
import me.bertilfrigaard.tether.ui.screens.createblock.setupblock.components.AppsSelector
import me.bertilfrigaard.tether.ui.screens.createblock.setupblock.components.BlockConditionSettings
import me.bertilfrigaard.tether.ui.screens.createblock.setupblock.components.BlockConditions
import me.bertilfrigaard.tether.ui.screens.createblock.setupblock.components.BlockPassSettings
import me.bertilfrigaard.tether.ui.screens.createblock.setupblock.components.BlockPersonalizer
import me.bertilfrigaard.tether.ui.theme.TetherTheme

@Composable
fun SetupBlockContent(
    state: SetupBlockUiState,
    sharedState: CreateBlockUiState,
    goBack: () -> Unit,
    goToSelectApps: () -> Unit,
    setSelectedCondition: (BlockConditions) -> Unit,
    setDailyUsage: (Int) -> Unit,
    setAllowPass: (Boolean) -> Unit,
    setDelayPassGrant: (Int) -> Unit,
    setMaxPassLength: (Int) -> Unit,
    setPassCooldown: (Int) -> Unit
) {
    Scaffold(
        topBar = {
            PageTopAppBar(title = "Setup block", onBack = goBack)
        }
    ) { innerPadding ->
        ScreenContent(modifier = Modifier.padding(innerPadding)) {
            LazyColumn() {
                item {
                    Text(
                        text = "What should we tether down?",
                        style = TetherTheme.typography.display,
                        color = TetherTheme.colors.ink
                    )
                }
                item {
                    Spacer(Modifier.height(10.dp))
                    Text(
                        text = "APP SELECTION",
                        style = TetherTheme.typography.overline,
                        color = TetherTheme.colors.ink2
                    )

                    Spacer(Modifier.height(8.dp))
                    AppsSelector(
                        selectedApps = sharedState.selectedApps,
                        blockName = sharedState.blockName,
                        onChangeSelection = goToSelectApps
                    )
                }
                item {
                    Spacer(Modifier.height(10.dp))
                    Text(
                        text = "PERSONALIZE BLOCK",
                        style = TetherTheme.typography.overline,
                        color = TetherTheme.colors.ink2
                    )

                    Spacer(Modifier.height(8.dp))
                    BlockPersonalizer()
                }
                item {
                    Spacer(Modifier.height(10.dp))
                    Text(
                        text = "RESTRICTIONS",
                        style = TetherTheme.typography.overline,
                        color = TetherTheme.colors.ink2
                    )
                }
                item {
                    Spacer(Modifier.height(8.dp))
                    BlockConditionSettings(
                        selectedCondition = state.selectedCondition,
                        setSelectCondition = setSelectedCondition,
                        dailyUsage = state.dailyUsage,
                        setDailyUsage = setDailyUsage
                    )
                }
                item {
                    Spacer(Modifier.height(8.dp))
                    BlockPassSettings(
                        allowPass = state.allowPass,
                        setAllowPass = setAllowPass,
                        delayPassGrant = state.delayPassGrant,
                        setDelayPassGrant = setDelayPassGrant,
                        maxPassLength = state.maxPassLength,
                        setMaxPassLength = setMaxPassLength,
                        passCooldown = state.passCooldown,
                        setPassCooldown = setPassCooldown
                    )
                }
            }
        }
    }
}