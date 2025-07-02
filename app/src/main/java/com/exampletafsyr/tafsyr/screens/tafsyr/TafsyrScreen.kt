package com.exampletafsyr.tafsyr.screens.tafsyr

import android.util.Log
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
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
import com.exampletafsyr.tafsyr.ui.theme.BackGColor1
import com.exampletafsyr.tafsyr.ui.theme.BackGColor2
import com.exampletafsyr.tafsyr.ui.theme.CardMainColor1
import com.exampletafsyr.tafsyr.ui.theme.CardMainColor2
import com.exampletafsyr.tafsyr.ui.theme.TextColor

@Composable
fun TafsyrScreen(
    navController: NavController,
    sharedVM: PassArgsSharedViewM
) {
    Log.d(
        "sayed-tafsyr-screen",
        sharedVM.ayaNum.value.toString() + " sura " + sharedVM.suraResult.value.size
    )
    val pagerState = rememberPagerState(pageCount = {
        sharedVM.suraResult.value.size
    }, initialPage = sharedVM.ayaNum.value!! - 1)
    val scrollState = rememberScrollState()
    val soura: String = Utils.surahNames[sharedVM.suraNumber.value!! - 1]

    HorizontalPager(
        state = pagerState, modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient
                    (colors = listOf(BackGColor1, BackGColor2))
            ), reverseLayout = true
    ) { page ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = when (sharedVM.tafsyrType.value) {
                        0 -> "Ibn Katheer"
                        1 -> "Al-Baghawy"
                        2 -> "Al-Tabry"
                        3 -> "Al-Saady"
                        else -> ""
                    },
                    fontSize = 15.sp,
                    color = TextColor,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily(Font(R.font.amiriquran))


                )
                Text(
                    text = when (sharedVM.tafsyrType.value) {
                        0 -> "ابن كثير"
                        1 -> "البغوي"
                        2 -> "الطبري"
                        3 -> "السعدي"
                        else -> ""
                    },
                    fontSize = 15.sp,
                    color = TextColor,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily(Font(R.font.amiriquran))

                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = soura,
                fontSize = 14.sp,
                color = TextColor,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.amiriquran))

            )
            Spacer(modifier = Modifier.height(10.dp))




            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(height = 32.dp, width = 40.dp)
                    .clip(CircleShape)
                    .background(
                        brush = Brush.linearGradient
                            (colors = listOf(CardMainColor1, CardMainColor2))
                    )
            ) {


                Text(
                    text = "${page + 1}",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )

            }


            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "${sharedVM.suraResult.value[page].aya_text}", fontSize = 13.sp,
                color = TextColor,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.amiriquran)),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    if (pagerState.currentPage != sharedVM.suraResult.value.size - 1) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
                            contentDescription = "next", tint = Color.Black,
                            modifier = Modifier.size(height = 30.dp, width = 25.dp)
                        )
                    }
                    if (pagerState.currentPage == sharedVM.suraResult.value.size - 1) {
                        Text(text = "")
                    }
                    if (pagerState.currentPage != 0) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
                            contentDescription = "back", tint = Color.Black,
                            modifier = Modifier
                                .size(height = 30.dp, width = 25.dp)
                                .graphicsLayer {
                                    scaleX = -1f
                                }
                        )
                    }
                }
            }
            Text(
                text = ": التفسير", fontSize = 16.sp,
                color = TextColor, modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily(Font(R.font.amiriquran)),
                textAlign = TextAlign.Right
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "${sharedVM.suraResult.value[page].content}", fontSize = 13.sp,
                color = TextColor,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily(Font(R.font.notonaskharabic_variablefont_wght)),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .clickable {
                        sharedVM.setAnimationFlag(1)
                        navController.popBackStack(route = "ayaListScreen", false)
                    }
                    .size(width = 180.dp, height = 40.dp)
                    .background(
                        brush = Brush.linearGradient
                            (colors = listOf(CardMainColor1, CardMainColor2)),
                        shape = RoundedCornerShape(12.dp)
                    ), contentAlignment = Alignment.Center
            ) {

                Text(
                    "خروج",
                    fontSize = 19.sp,
                    fontFamily = FontFamily(Font(R.font.notonaskharabic_variablefont_wght)),
                    color = Color.White
                )


            }

        }

    }

}


@Preview
@Composable
fun TafsyrPreview() {
    //TafsyrScreen()
}