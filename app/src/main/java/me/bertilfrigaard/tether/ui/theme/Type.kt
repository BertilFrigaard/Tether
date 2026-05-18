package me.bertilfrigaard.tether.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import me.bertilfrigaard.tether.R

val Geist: FontFamily = FontFamily(
    Font(R.font.geist_regular,  FontWeight.Normal),
     Font(R.font.geist_medium,   FontWeight.Medium),
     Font(R.font.geist_semibold, FontWeight.SemiBold),
     Font(R.font.geist_bold,     FontWeight.Bold),
 )

data class TetherTypography(
    /**
     * Used for big intervention message
     * fx. "STOP"
     */
    val bam: TextStyle = TextStyle(
        fontFamily = Geist,
        fontWeight = FontWeight.Bold,
        fontSize = 140.sp,
        lineHeight = 34.sp,
        letterSpacing = (-8).sp,
    ),

    /**
     * Page hero / big numbers.
     * Use for the question that opens a screen ("What should we tether down?")
     * and for prominent metrics ("1h 42m saved today").
     * Usually one per screen — don't stack two.
     */
    val display: TextStyle = TextStyle(
        fontFamily = Geist,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        lineHeight = 34.sp,
        letterSpacing = (-1.1).sp,
    ),

    /**
     * Section / dialog / screen titles.
     * Use for top-app-bar titles ("New block"), bottom-sheet headlines,
     * and the bigger heading inside a card group.
     */
    val title: TextStyle = TextStyle(
        fontFamily = Geist,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 26.sp,
        letterSpacing = (-0.6).sp,
    ),

    /**
     * The app's logotype — used only for the "tether" wordmark in the
     * home header. Don't reuse for regular titles; reach for `display` or
     * `title` instead.
     */
    val wordmark: TextStyle = TextStyle(
        fontFamily = Geist,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
        lineHeight = 30.sp,
        letterSpacing = (-1.1).sp,
    ),

    /**
     * Bold body — the primary line in a two-line row.
     * Use for list item headlines ("Pass timer", app name in a block card),
     * card titles, and any inline label that needs to read first.
     */
    val bodyEmphasis: TextStyle = TextStyle(
        fontFamily = Geist,
        fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp,
        lineHeight = 20.sp,
        letterSpacing = (-0.15).sp,
    ),

    /**
     * Default paragraph + secondary line in a two-line row.
     * Use with `ink` for full-weight body copy and with `ink2` for
     * supporting descriptions under a `bodyEmphasis` headline.
     */
    val body: TextStyle = TextStyle(
        fontFamily = Geist,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp,
    ),

    /**
     * Small print under a row or chart.
     * Use with `ink3` for usage stats ("2m today", "Paused"), helper hints
     * ("Tap to change"), and metadata. Don't use as primary body.
     */
    val caption: TextStyle = TextStyle(
        fontFamily = Geist,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.1.sp,
    ),

    /**
     * ALL CAPS section labels above a group.
     * Use with `ink2` for "ACTIVE BLOCKS", "RESTRICTIONS", "SCHEDULE".
     * Render uppercase at the call site — this style does NOT force casing.
     */
    val overline: TextStyle = TextStyle(
        fontFamily = Geist,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 1.5.sp,
    ),

    /**
     * Text inside buttons — primary CTAs, pill buttons, FABs.
     * Use for any tappable control with a label. Keep buttons to a single
     * line; if it wraps, your button is too narrow or the label too long.
     */
    val bigButton: TextStyle = TextStyle(
        fontFamily = Geist,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 18.sp,
        letterSpacing = (-0.1).sp,
    ),

    val button: TextStyle = TextStyle(
        fontFamily = Geist,
        fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp,
        lineHeight = 18.sp,
        letterSpacing = (-0.1).sp,
    ),

    /**
     * Tabular / technical text — timer values, counters, code-like data.
     * Use for the stepper digit, countdown timers, and anywhere numbers
     * need to line up vertically.
     */
    val mono: TextStyle = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp,
    ),
)

//Is it the big thing on the screen?    → display
//Is it a screen / sheet title?         → title (or wordmark only for the logo)
//Is it the bolder line of a row?       → bodyEmphasis
//Is it regular paragraph text or the lighter second line?  → body
//Is it smaller helper / status text?   → caption
//Is it a SHOUTY SECTION HEADER?        → overline
//Is it inside a button?                → button
//Is it a number that needs to align?   → mono

internal val LocalTetherTypography = staticCompositionLocalOf { TetherTypography() }

internal fun tetherM3Typography(t: TetherTypography = TetherTypography()) = Typography(
    displayLarge   = t.display,
    displayMedium  = t.display,
    displaySmall   = t.title,
    headlineLarge  = t.title,
    headlineMedium = t.title,
    headlineSmall  = t.title,
    titleLarge     = t.title,
    titleMedium    = t.bodyEmphasis,
    titleSmall     = t.bodyEmphasis,
    bodyLarge      = t.body,
    bodyMedium     = t.body,
    bodySmall      = t.caption,
    labelLarge     = t.button,
    labelMedium    = t.overline,
    labelSmall     = t.overline,
)
