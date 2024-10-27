package com.example.medicaonlinedoctor.view

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DotsSequentialFlashingCircle(
    modifier: Modifier = Modifier,
    dotCount: Int = 8,
    minDotSize:Float=4f,
    maxDotSize: Float = 15f,
    radius: Float = 60f
) {
    val transition = rememberInfiniteTransition()

    // Har bir nuqtaning alfa qiymatini ketma-ket o'zgarishini animatsiyalaymiz
    val alphaValues = List(dotCount) { index ->
        transition.animateFloat(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = keyframes {
                  durationMillis = 1500+index * 10 // Har bir nuqta uchun ketma-ket kechikish qo'shamiz
                 // 0f at 0 with LinearEasing                 // Dastlab ko'rinmas
                  //0f at 2000 + index * 250 with LinearEasing // 1 sekundda yo'qoladi
                    //1f at 1000 + index * 250 with LinearEasing // 2 sekundda paydo bo'ladi
                },
                repeatMode = RepeatMode.Restart
            )
        )
    }
    Canvas(modifier = modifier.size(100.dp)) {
        for (i in 0 until dotCount) {
            // Aylanada nuqtalar joylashishi uchun kerakli burchakni hisoblaymiz
            val angleInDegrees = (360f / dotCount) * i
            val radianAngle = Math.toRadians(angleInDegrees.toDouble())
            val x = (radius * kotlin.math.cos(radianAngle)).toFloat()
            val y = (radius * kotlin.math.sin(radianAngle)).toFloat()

            drawCircle(
                color = Color.Blue,
                radius = minDotSize+i*1.5f,
                center = Offset(x = x + size.width / 2, y = y + size.height / 2),
                alpha = alphaValues[i].value
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun show(){

DotsSequentialFlashingCircle(modifier = Modifier.size(100.dp))
}