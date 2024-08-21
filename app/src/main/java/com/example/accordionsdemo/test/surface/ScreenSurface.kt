package com.example.accordionsdemo.test.surface

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ScreenSurfaceView(){
    Surface(
        color = Color.White,  // Background color of the Surface
        shape = RoundedCornerShape(16.dp),  // Shape with rounded corners
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        // Content inside the Surface
        Text(
            text = "Hello, Surface!",
            color = Color.Black,
            modifier = Modifier.padding(16.dp)
                .shadow(elevation = 8.dp, shape = RoundedCornerShape(16.dp))
        )
    }
}
/*
* Surface hold content, apply elevation, define shapes, borders and background colors
*
* */