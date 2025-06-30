package com.exampletafsyr.tafsyr.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.exampletafsyr.tafsyr.PassArgsSharedViewM
import com.exampletafsyr.tafsyr.composables.Header
import com.exampletafsyr.tafsyr.composables.MainCardText
import com.exampletafsyr.tafsyr.ui.theme.CardMainColor1
import com.exampletafsyr.tafsyr.ui.theme.CardMainColor2

@Composable
fun HomeScreen(
    navController: NavController,
    sharedViewModel: PassArgsSharedViewM
) {
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
                Card(modifier = Modifier.clickable(){
                    sharedViewModel.saveTafsyrType(0)
                    navController.navigate("suraListScreen")
                }) {
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
                Card(modifier = Modifier.clickable(){
                    sharedViewModel.saveTafsyrType(1)
                    navController.navigate("suraListScreen")
                }) {
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
                Card(modifier = Modifier.clickable(){
                    sharedViewModel.saveTafsyrType(2)
                    navController.navigate("suraListScreen")
                }) {
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
                Card (modifier = Modifier.clickable(){
                    sharedViewModel.saveTafsyrType(3)
                    navController.navigate("suraListScreen")
                }){
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
    //HomeScreen()
}