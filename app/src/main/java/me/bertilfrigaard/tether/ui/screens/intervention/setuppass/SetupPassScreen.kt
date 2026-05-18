package me.bertilfrigaard.tether.ui.screens.intervention.setuppass

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import me.bertilfrigaard.tether.ui.screens.intervention.InterventionViewModel

@Composable
fun SetupPassScreen(sharedVm: InterventionViewModel, onFinished: () -> Unit) {
    val context = LocalContext.current
    val sharedState by sharedVm.uiState.collectAsStateWithLifecycle()

    SetupPassContent(sharedState = sharedState, onGoHome = {
        val home = Intent(Intent.ACTION_MAIN).apply {
            addCategory(Intent.CATEGORY_HOME)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        context.startActivity(home)
        onFinished()
    }, setPassLength = sharedVm::setPassLength, createPass = {
        sharedVm.createPass {
            sharedState.appInfo?.packageName?.let { pkg ->
                context.packageManager.getLaunchIntentForPackage(pkg)?.let { launch ->
                    launch.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    context.startActivity(launch)
                }
            }
            onFinished()
        }
    })
}