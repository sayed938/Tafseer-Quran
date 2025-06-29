package com.exampletafsyr.tafsyr.screens.aya

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exampletafsyr.core.Utils
import com.exampletafsyr.tafsyr.R
import com.exampletafsyr.tafsyr.ui.theme.CardMainColor1
import com.exampletafsyr.tafsyr.ui.theme.CardMainColor2

@SuppressLint("MutableCollectionMutableState")
@Composable
fun AyahListScreen() {
    var input by remember { mutableStateOf("") }
    var hintText by remember { mutableStateOf("ادخل") }
    var aya by remember { mutableStateOf(Utils.aya) }
    var ayaNumbers by remember { mutableStateOf(Utils.numbers) }
    var ayaResult by remember { mutableStateOf("") }
    var numResult by remember { mutableStateOf(0) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient
                    (colors = listOf(CardMainColor1, CardMainColor2))
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                painter = painterResource(R.drawable.baseline_arrow_forward_ios_24),
                contentDescription = "next",
                modifier = Modifier.size(height = 25.dp, width = 30.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = " سورة : ${"البقرة"}",
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp,
                fontFamily = FontFamily(Font(R.font.amiriquran))
            )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = " رقم السورة : ${2}",
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp,
                fontFamily = FontFamily(Font(R.font.amiriquran))
            )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = " ادخل رقم الاية التي تريد تفسيرها او اختر من القائمة",
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp,
                fontFamily = FontFamily(Font(R.font.amiriquran))
            )
        }

        OutlinedTextField(
            modifier = Modifier.width(65.dp), textStyle = TextStyle(textAlign = TextAlign.Center),
            value = input, maxLines = 1,
            onValueChange = {
                input = it
            },
            singleLine = true,
            label = {
                Text(
                    hintText,
                    color = Color.Black,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyVerticalGrid(columns = GridCells.Fixed(count = 1)) {
            if (input == "") {
                hintText = "ادخل"
                items(ayaNumbers.size) {
                    AyahCustom(aya[it], ayaNumbers[it])
                }
            } else {
                if (input.toInt() > 286) {
                    hintText = "خطأ"
                } else
                    items(1) {
                        if (input.toInt() > 0 && input.toInt() <= 114) {
                            hintText = ""
                            ayaResult = aya[input.toInt() - 1]
                            numResult = input.toInt()
                            AyahCustom(ayaResult, numResult)
                        } else
                            hintText = "خطأ"
                    }
            }

        }
    }
}

@Composable
fun AyahCustom(aya: String, ayaNum: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp), border = BorderStroke(1.dp, CardMainColor1),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp)
                .background(
                    brush = Brush.linearGradient
                        (colors = listOf(CardMainColor1, CardMainColor2))
                )
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFCEBB3))
            ) {
                Text(
                    text = "${ayaNum}",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = "${aya}",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold, fontFamily = FontFamily(Font(R.font.amiriquran))
            )
        }
    }
}

@Preview
@Composable
fun AyahPreview() {
    AyahListScreen()
}