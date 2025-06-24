package com.exampletafsyr.tafsyr.screens

import androidx.annotation.ContentView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.exampletafsyr.tafsyr.composables.Header
import com.exampletafsyr.tafsyr.composables.MainCardText
import com.exampletafsyr.tafsyr.ui.theme.CardMainColor1
import com.exampletafsyr.tafsyr.ui.theme.CardMainColor2

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Header("Tafsyr")
        Spacer(Modifier.height(60.dp))
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card {
                    Box(
                        modifier = Modifier
                            .background(
                                brush = Brush.linearGradient
                                    (colors = listOf(CardMainColor1, CardMainColor2))
                            )
                            .size(150.dp), contentAlignment = Alignment.Center
                    ) {
                        Column(verticalArrangement = Arrangement.SpaceEvenly) {
                            MainCardText("Ibn Kathyr")
                            MainCardText("ابن كثير")
                        }
                    }
                }
                Card {
                    Box(
                        modifier = Modifier
                            .background(
                                brush = Brush.linearGradient
                                    (colors = listOf(CardMainColor1, CardMainColor2))
                            )
                            .size(150.dp), contentAlignment = Alignment.Center
                    ) {
                        Column(verticalArrangement = Arrangement.SpaceEvenly) {
                            MainCardText("ِِAl-baghawy")
                            MainCardText("البغوي")
                        }
                    }
                }
            }
            Spacer(Modifier.height(50.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card {
                    Box(
                        modifier = Modifier
                            .background(
                                brush = Brush.linearGradient
                                    (colors = listOf(CardMainColor1, CardMainColor2))
                            )
                            .size(150.dp), contentAlignment = Alignment.Center
                    ) {
                        Column(verticalArrangement = Arrangement.SpaceEvenly) {
                            MainCardText("Al-tbry")
                            MainCardText("الطبري")
                        }
                    }
                }
                Card {
                    Box(
                        modifier = Modifier
                            .background(
                                brush = Brush.linearGradient
                                    (colors = listOf(CardMainColor1, CardMainColor2))
                            )
                            .size(150.dp), contentAlignment = Alignment.Center
                    ) {
                        Column(verticalArrangement = Arrangement.SpaceEvenly) {
                            MainCardText("Al-sady")
                            MainCardText("السعدي")
                        }
                    }
                }
            }
        }

    }
}

@Preview
@Composable
fun Preview() {
    HomeScreen()
}