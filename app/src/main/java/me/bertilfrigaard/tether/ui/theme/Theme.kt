package me.bertilfrigaard.tether.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

val DefaultPalette: TetherPalette = SageStone

private val LocalTetherPalette = staticCompositionLocalOf { DefaultPalette }

object TetherTheme {
    val colors: TetherPalette
        @Composable @ReadOnlyComposable
        get() = LocalTetherPalette.current

    val typography: TetherTypography
        @Composable @ReadOnlyComposable
        get() = LocalTetherTypography.current
}

@Composable
fun TetherTheme(
    palette: TetherPalette = DefaultPalette,
    content: @Composable () -> Unit
) {
    val m3Scheme = if (palette.isDark) {
        darkColorScheme(
            background = palette.bg,
            surface = palette.surface,
            surfaceVariant = palette.surface2,
            onBackground = palette.ink,
            onSurface = palette.ink,
            onSurfaceVariant = palette.ink2,
            primary = palette.accent,
            onPrimary = palette.accentInk,
            primaryContainer = palette.accentSoft,
            onPrimaryContainer = palette.ink,
            outline = palette.hairline,
            error = palette.danger,
        )
    } else {
        lightColorScheme(
            background = palette.bg,
            surface = palette.surface,
            surfaceVariant = palette.surface2,
            onBackground = palette.ink,
            onSurface = palette.ink,
            onSurfaceVariant = palette.ink2,
            primary = palette.accent,
            onPrimary = palette.accentInk,
            primaryContainer = palette.accentSoft,
            onPrimaryContainer = palette.ink,
            outline = palette.hairline,
            error = palette.danger,
        )
    }

    CompositionLocalProvider(
        LocalTetherPalette provides palette,
        LocalTetherTypography provides TetherTypography(),
    ) {
        MaterialTheme(
            colorScheme = m3Scheme,
            typography = tetherM3Typography(),
            content = content,
        )
    }
}
