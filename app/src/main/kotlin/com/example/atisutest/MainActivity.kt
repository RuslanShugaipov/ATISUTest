package com.example.atisutest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.atisutest.core.ui.theme.ATISUTESTTheme
import com.example.atisutest.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

private const val TRANSPARENT_COLOR = android.graphics.Color.TRANSPARENT

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                scrim = TRANSPARENT_COLOR,
                darkScrim = TRANSPARENT_COLOR,
            ),
            navigationBarStyle = SystemBarStyle.light(TRANSPARENT_COLOR, TRANSPARENT_COLOR)
        )

        setContent {
            ATISUTESTTheme {
                Navigation()
            }
        }
    }
}
