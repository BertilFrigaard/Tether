package me.bertilfrigaard.tether.ui.screens.intervention.passdelay

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import me.bertilfrigaard.tether.ui.screens.intervention.InterventionViewModel

@Composable
fun PassDelayScreen(
    sharedVm: InterventionViewModel, onFinished: () -> Unit, onGoSetupPass: () -> Unit
) {
    val context = LocalContext.current
    val sharedState by sharedVm.uiState.collectAsStateWithLifecycle()
    PassDelayContent(sharedState = sharedState, onGoHome = {
        val home = Intent(Intent.ACTION_MAIN).apply {
            addCategory(Intent.CATEGORY_HOME)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        context.startActivity(home)
        onFinished()
    }, onGoSetupPass = onGoSetupPass)
}