package me.bertilfrigaard.tether.ui.theme

import androidx.compose.ui.graphics.Color

interface TetherPalette {
    val name: String
    val isDark: Boolean

    val bg: Color           // Screen background
    val surface: Color      // Cards
    val surface2: Color     // Chips

    val ink: Color          // Primary Text
    val ink2: Color         // Secondary Text
    val ink3: Color         // Disabled Text
    val ink4: Color         // Lighter Text

    val accent: Color       // primary action / brand
    val accentMedium: Color // Lighter accent for surface on accent
    val accentInk: Color    // text/icon on accent
    val accentSoft: Color   // tinted accent background

    val hairline: Color     // dividers, card borders
    val danger: Color       // destructive / errors
}

object SageStone : TetherPalette {
    override val name = "Sage & Stone"
    override val isDark = false

    override val bg = Color(0xFFF1EDE4) //#f1ede4
    override val surface = Color(0xFFFBF8F1) //rgb(251,248,241)
    override val surface2 = Color(0xFFE8E3D6)

    override val ink = Color(0xFF1E2420)
    override val ink2 = Color(0xFF4A534C)
    override val ink3 = Color(0xFF8A9089)
    override val ink4 = Color(0xFFC6CEC4)

    override val accent = Color(0xFF4C6A4F)
    override val accentMedium = Color(0xFF6C856F) //rgb(108,133,111)
    override val accentInk = Color(0xFFF5F2E9)
    override val accentSoft = Color(0xFFDDE6DB)

    override val hairline = Color(0x1A1E2420)
    override val danger = Color(0xFFA13D2D)
}