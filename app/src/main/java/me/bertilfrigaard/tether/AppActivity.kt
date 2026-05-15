package me.bertilfrigaard.tether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import me.bertilfrigaard.tether.nav.app.AppNavDisplay
import me.bertilfrigaard.tether.ui.theme.TetherTheme

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TetherTheme {
                AppNavDisplay()
            }
        }
    }
}
