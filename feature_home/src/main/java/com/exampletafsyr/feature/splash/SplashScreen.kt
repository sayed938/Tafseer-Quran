package com.exampletafsyr.feature.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseOutBounce
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exampletafsyr.core.R
import androidx.navigation.NavController
import com.exampletafsyr.core.colors.CardMainColor1
import com.exampletafsyr.core.colors.CardMainColor2
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember { Animatable(0f) }
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        launch {
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 3000, easing = EaseOutBounce)
            )
        }
        launch {
            alpha.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 3000)
            )
        }

        delay(2000)
        navController.navigate("homeScreen") {
            popUpTo("splashScreen") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(CardMainColor1, CardMainColor2)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = R.drawable.new_logo),
                contentDescription = "Logo",
                tint = Color.White,
                modifier = Modifier
                    .size(100.dp)
                    .graphicsLayer(
                        scaleX = scale.value,
                        scaleY = scale.value,
                        alpha = alpha.value
                    )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Tafsyr",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.graphicsLayer(alpha = alpha.value)
            )
        }
    }
}

@Preview
@Composable
fun PreviewScreen() {
    // تحتاج تمرير NavController mock لو حبيت تجرب المعاينة
}
