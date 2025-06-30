package com.exampletafsyr.tafsyr.screens.sura

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.exampletafsyr.core.Utils
import com.exampletafsyr.tafsyr.PassArgsSharedViewM
import com.exampletafsyr.tafsyr.R
import com.exampletafsyr.tafsyr.ui.theme.CardMainColor1
import com.exampletafsyr.tafsyr.ui.theme.CardMainColor2
import com.exampletafsyr.tafsyr.ui.theme.CardMainColor3

@Composable
fun SuraListScreen(
    navController: NavController,
    sharedVM: PassArgsSharedViewM
) {
    Log.d("sayed-resu : ", sharedVM.tafsyrType.value.toString())
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color.White
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "اختر السورة",
                fontFamily = FontFamily(Font(R.font.amiriquran)),
                fontSize = 20.sp, color = Color.Black,
                fontWeight = (FontWeight.ExtraBold), textAlign = TextAlign.Center
            )
        }
        Box(
            modifier = Modifier.padding(horizontal = 4.dp),
            contentAlignment = Alignment.BottomCenter
        ) {

            LazyVerticalGrid(
                columns = GridCells.Fixed(count = 3),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                items(Utils.surahNames.size) {
                    SuraNames(Utils.surahNames[it], Utils.surahNumbers[it], navController, sharedVM)
                }

            }
            /* Box(
                 modifier = Modifier
                     .size(width = 180.dp, height = 40.dp)
                     .background(
                         brush = Brush.linearGradient
                             (colors = listOf(AyaColor, CardMainColor2)),
                         shape = RoundedCornerShape(12.dp)
                     ), contentAlignment = Alignment.Center
             ) {
                 Text(
                     "رجوع",
                     fontSize = 19.sp,
                     fontFamily = FontFamily(Font(R.font.notonaskharabic_variablefont_wght)),
                     color = Color.White
                 )

             }*/

        }
    }


}

@Composable
fun SuraNames(
    suraName: String,
    suraNum: Int,
    navController: NavController,
    sharedViewM: PassArgsSharedViewM
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(2.dp)
            .clickable {
                sharedViewM.saveTSuraNum(suraNum)
                navController.navigate("ayaListScreen")
            },
        elevation = CardDefaults.cardElevation(4.dp),
        border = _root_ide_package_.androidx.compose.foundation.BorderStroke(
            2.dp, brush = Brush.linearGradient
                (colors = listOf(CardMainColor1, CardMainColor3))
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp)
                .background(
                    brush = Brush.linearGradient
                        (colors = listOf(CardMainColor1, CardMainColor3))
                )
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFCEBB3))
            ) {
                Text(
                    text = "${suraNum}",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold, fontSize = 12.sp
                )
            }
            Text(
                text = "${suraName}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold, color = Color(0xFFFCEBB3)
            )
        }
    }
}

@Preview
@Composable
fun SuraPreview() {
    //SuraListScreen()
}