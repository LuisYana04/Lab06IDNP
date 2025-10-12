package com.example.twoscreens.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.example.twoscreens.R
import com.example.twoscreens.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun AdaptiveScreen(windowSizeClass: WindowSizeClass) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    val hPadding: Dp
    val vPadding: Dp
    val titleStyle: TextStyle
    val buttonHeight: Dp
    val buttonFraction: Float

    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            hPadding = 16.dp; vPadding = 16.dp
            titleStyle = MaterialTheme.typography.headlineMedium
            buttonHeight = 48.dp
            buttonFraction = 1f
        }
        WindowWidthSizeClass.Medium -> {
            hPadding = 24.dp; vPadding = 24.dp
            titleStyle = MaterialTheme.typography.headlineLarge
            buttonHeight = 56.dp
            buttonFraction = 0.6f
        }
        WindowWidthSizeClass.Expanded -> {
            hPadding = 32.dp; vPadding = 32.dp
            titleStyle = MaterialTheme.typography.displaySmall
            buttonHeight = 64.dp
            buttonFraction = 0.6f
        }
        else -> {
            hPadding = 16.dp; vPadding = 16.dp
            titleStyle = MaterialTheme.typography.headlineMedium
            buttonHeight = 48.dp
            buttonFraction = 1f
        }
    }

    val content: @Composable ColumnScope.() -> Unit = {
        Text(
            text = stringResource(id = R.string.app_title),
            style = titleStyle,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .semantics { heading() }
        )
        Spacer(Modifier.height(24.dp))
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .height(buttonHeight)
                .fillMaxWidth(buttonFraction)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(stringResource(id = R.string.primary_action))
        }
    }

    val baseModifier = Modifier
        .fillMaxSize()
        .padding(horizontal = hPadding, vertical = vPadding)
        .verticalScroll(rememberScrollState())

    if (isLandscape && windowSizeClass.widthSizeClass != WindowWidthSizeClass.Compact) {
        Row(
            modifier = baseModifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .widthIn(max = 600.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                content = content
            )
        }
    } else {
        Column(
            modifier = baseModifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            content = content
        )
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true, name = "Phone")
@Composable
private fun PreviewPhone() {
    AppTheme {
        AdaptiveScreen(
            windowSizeClass = WindowSizeClass.calculateFromSize(DpSize(411.dp, 891.dp))
        )
    }
}
