package com.exampletafsyr.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.exampletafsyr.core.shared.PassArgsSharedViewM
import com.exampletafsyr.core.composables.Header
import com.exampletafsyr.core.composables.HomeCard

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
                HomeCard(sharedViewModel, navController, "ِِIbn Katheer", "ابن كثير", 0)
                HomeCard(sharedViewModel, navController, "ِِAl-baghawy", "البغوي", 1)
            }
            Spacer(Modifier.height(50.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                HomeCard(sharedViewModel, navController, "Al-Tabry", "الطبري", 2)
                HomeCard(sharedViewModel, navController, "Al-Sady", "السعدي", 3)
            }
        }

    }
}
