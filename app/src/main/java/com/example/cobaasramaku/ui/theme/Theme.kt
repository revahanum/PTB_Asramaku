package com.example.cobaasramaku.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color


val BackgroundColor = Color(0xFFFFEED1)
val PrimaryTeal = Color(0xFF2E666E)
val LightTeal = Color(0xFF99CAC4)
val DarkYellow = Color(0xFFF6D1A4)


private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryTeal,
    secondary = LightTeal,
    tertiary = DarkYellow,
    background = BackgroundColor,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = PrimaryTeal,
    onBackground = PrimaryTeal,
    onSurface = PrimaryTeal,
)

@Composable
fun CobaAsramakuTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}