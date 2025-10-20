package com.example.twoscreens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircleAnimationScreen()
        }
    }
}

@Composable
fun CircleAnimationScreen() {

    var expanded by remember { mutableStateOf(false) }


    val animatedRadius by animateFloatAsState(
        targetValue = if (expanded) 200f else 80f,
        label = "circleRadius"
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Canvas(
            modifier = Modifier
                .size(300.dp)
        ) {
            drawCircle(
                color = Color(0xFF4CAF50), // verde
                radius = animatedRadius
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Botón para cambiar el estado (y animar)
        Button(onClick = { expanded = !expanded }) {
            Text(text = if (expanded) "Reducir" else "Expandir")
        }
    }
}
