package com.exampletafsyr.tafsyr.screens.aya

import android.annotation.SuppressLint
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.exampletafsyr.core.Utils
import com.exampletafsyr.domain.entities.AyaDataModel
import com.exampletafsyr.tafsyr.PassArgsSharedViewM
import com.exampletafsyr.tafsyr.R
import com.exampletafsyr.tafsyr.TafsyrViewM
import com.exampletafsyr.tafsyr.ui.theme.CardMainColor1
import com.exampletafsyr.tafsyr.ui.theme.CardMainColor3
import kotlinx.coroutines.flow.StateFlow

@SuppressLint("MutableCollectionMutableState")
@Composable
fun AyahListScreen(
    navController: NavController,
    sharedVM: PassArgsSharedViewM,
    tafsyrVM: TafsyrViewM = hiltViewModel()
) {

    tafsyrVM.setTafsyrType(sharedVM.tafsyrType.value!!, sharedVM.suraName.value!!)

    val katheer by tafsyrVM.tafsyrQuranKatheer.collectAsState()
    val baghawy by tafsyrVM.tafsyrQuranBaghawy.collectAsState()
    val tbry by tafsyrVM.tafsyrQuranTbry.collectAsState()
    val sady by tafsyrVM.tafsyrQuranSady.collectAsState()
    Log.d(
        "sayed-res-name",
        sharedVM.tafsyrType.value.toString() + " "
    )
    val resultTafsyr = when (sharedVM.tafsyrType.value) {
        0 -> katheer
        1 -> baghawy
        2 -> tbry
        3 -> sady
        else -> emptyList()
    }
    Log.d(
        "sayed-res-name",
        sharedVM.suraName.value.toString() + " " + resultTafsyr.size
    )
    var input by remember { mutableStateOf("") }
    var hintText by remember { mutableStateOf("ادخل") }
    var aya by remember { mutableStateOf(Utils.aya) }
    var ayaNumbers by remember { mutableStateOf(Utils.numbers) }
    var ayaResult by remember { mutableStateOf("") }
    var numResult by remember { mutableStateOf(0) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                painter = painterResource(R.drawable.baseline_arrow_forward_ios_24),
                contentDescription = "next", tint = Color(0xFFC4A94B),
                modifier = Modifier
                    .size(height = 25.dp, width = 30.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = " سورة : ${Utils.surahNames[sharedVM.suraName.value!! - 1]}",
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp, color = Color(0xFFC4A94B),
                fontFamily = FontFamily(Font(R.font.amiriquran))
            )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = " رقم السورة : ${sharedVM.suraName.value!!}",
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp, color = Color(0xFFC4A94B),
                fontFamily = FontFamily(Font(R.font.amiriquran))
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = " ادخل رقم الاية التي تريد تفسيرها او اختر من القائمة",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp, color = Color(0xFFC4A94B), textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.amiriquran))
            )
        }

        OutlinedTextField(
            modifier = Modifier.size(65.dp), textStyle = TextStyle(textAlign = TextAlign.Center),
            value = input, maxLines = 1,
            onValueChange = {
                input = it
            },
            singleLine = true,
            label = {
                Text(
                    hintText,
                    color = Color(0xFFC4A94B),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ), colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFFFF8E1),
                unfocusedContainerColor = Color(0xFFFFF8E1),
                focusedIndicatorColor = Color(0xFFC4A94B),
                unfocusedIndicatorColor = Color.Gray,
                cursorColor = Color(0xFFC4A94B),
                focusedLabelColor = Color(0xFFC4A94B),
                unfocusedLabelColor = Color(0xFFC4A94B),
                disabledLabelColor = Color.Gray,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(10.dp))

        LazyVerticalGrid(columns = GridCells.Fixed(count = 1)) {
            if (input == "") {
                hintText = "ادخل"
                items(resultTafsyr.size) {
                    AyahCustom(
                        resultTafsyr.get(it).aya_text!!,
                        resultTafsyr.size,
                        sharedVM,
                        navController
                    )
                }
            } else {
                if (input.toInt() > resultTafsyr.size) {
                    hintText = "خطأ"
                } else
                    items(1) {
                        if (input.toInt() > 0 && input.toInt() <= resultTafsyr.size) {
                            hintText = ""
                            ayaResult = resultTafsyr[input.toInt() - 1].aya_text!!
                            numResult = input.toInt()
                            AyahCustom(ayaResult, numResult, sharedVM, navController)
                        } else
                            hintText = "خطأ"
                    }
            }

        }
    }
}

@Composable
fun AyahCustom(
    aya: String,
    ayaNum: Int,
    sharedViewM: PassArgsSharedViewM,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(top = 2.dp, bottom = 2.dp, start = 5.dp, end = 5.dp)
            .clickable {
                sharedViewM.saveTSuraNum(ayaNum)
                navController.navigate("tafsyrScreen")
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
                    text = "${ayaNum}",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold, fontSize = 12.sp
                )
            }
            Text(
                text = "${aya}", maxLines = 1,
                fontSize = 16.sp, textAlign = TextAlign.Right,
                fontWeight = FontWeight.Bold, color = Color(0xFFFCEBB3)
            )
        }
    }
}

@Preview
@Composable
fun AyahPreview() {
    //AyahListScreen()
}