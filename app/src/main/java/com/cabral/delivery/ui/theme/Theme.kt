package com.cabral.delivery.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorPalette = darkColorScheme(
    primary = Indigo400,
    onPrimary = Indigo400Light,
    secondary = Indigo500,
    onSecondary = Color.White
)

private val LightColorPalette = lightColorScheme(
    primary = Indigo400,
    onPrimary = Indigo400Light,
    secondary = Indigo500,
    onSecondary = Color.White

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)
@Composable
fun DeliveryTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    // Acessa a View local para encontrar a Activity
    val view = LocalView.current
    if (!view.isInEditMode) {
        // Usa um SideEffect para mudar as cores das barras
        SideEffect {
            val window = (view.context as Activity).window
            val insetsController = WindowCompat.getInsetsController(window, view)

            // Define a cor da barra de status
            window.statusBarColor = colors.background.toArgb()

            // Define a cor dos ícones da barra de status
            insetsController.isAppearanceLightStatusBars = !darkTheme

            // Define a cor da barra de navegação
            window.navigationBarColor = colors.background.toArgb()

            // Define a cor dos ícones da barra de navegação
            insetsController.isAppearanceLightNavigationBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}