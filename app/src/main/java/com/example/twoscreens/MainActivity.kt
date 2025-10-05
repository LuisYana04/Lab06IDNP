@file:OptIn(androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi::class)
package com.example.twoscreens


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.twoscreens.ui.AdaptiveScreen
import com.example.twoscreens.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val wsc = calculateWindowSizeClass(this)
                AdaptiveScreen(windowSizeClass = wsc)
            }
        }
    }
}
