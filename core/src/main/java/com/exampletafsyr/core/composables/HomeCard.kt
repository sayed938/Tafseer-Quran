package com.exampletafsyr.core.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.exampletafsyr.core.colors.CardMainColor1
import com.exampletafsyr.core.colors.CardMainColor2
import com.exampletafsyr.core.shared.PassArgsSharedViewM

@Composable
fun HomeCard(
    sharedViewModel: PassArgsSharedViewM,
    navController: NavController,
    tafsyrTypeEn: String,
    tafsyrTypeAr: String,
    res: Int
) {
    Card(modifier = Modifier.clickable() {
        sharedViewModel.saveTafsyrType(res)
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
                MainCardText(tafsyrTypeEn)
                MainCardText(tafsyrTypeAr)
            }
        }
    }
}