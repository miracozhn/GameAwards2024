package com.example.gameawards2024.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoadingAnimation(
    modifier: Modifier = Modifier,
    circleSize: Float = 25f,
    spaceBetween: Float = 10f,
    travelDistance: Float = 20f
) {
    val circles = listOf(
        rememberInfiniteTransition().animateFloat(
            initialValue = 0f,
            targetValue = travelDistance,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1200, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        ),
        rememberInfiniteTransition().animateFloat(
            initialValue = 0f,
            targetValue = travelDistance,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1200, delayMillis = 300, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        ),
        rememberInfiniteTransition().animateFloat(
            initialValue = 0f,
            targetValue = travelDistance,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1200, delayMillis = 600, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
    )

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        circles.forEachIndexed { index, animation ->
            val offset by animation
            Box(
                modifier = Modifier
                    .size(circleSize.dp)
                    .offset(y = -offset.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    )
            )
            if (index != circles.lastIndex) {
                Spacer(modifier = Modifier.width(spaceBetween.dp))
            }
        }
    }
} 