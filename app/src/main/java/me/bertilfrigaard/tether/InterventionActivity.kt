package me.bertilfrigaard.tether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import me.bertilfrigaard.tether.nav.intervention.InterventionNavDisplay
import me.bertilfrigaard.tether.ui.theme.TetherTheme

class InterventionActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pkg = intent.getStringExtra(EXTRA_BLOCKED_PACKAGE).orEmpty()

        enableEdgeToEdge()
        setContent {
            TetherTheme {
                InterventionNavDisplay(pkg = pkg, onFinished = { finishAndRemoveTask() })
            }
        }
    }

    companion object {
        const val EXTRA_BLOCKED_PACKAGE = "extra_blocked_package"
    }
}