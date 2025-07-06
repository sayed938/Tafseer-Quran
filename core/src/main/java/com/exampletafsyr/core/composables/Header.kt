package com.exampletafsyr.core.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exampletafsyr.core.colors.CardMainColor2

@Composable
fun Header(txt: String) {
    Text(
        text = txt,
        color = CardMainColor2,
        fontSize = 25.sp,
        modifier = Modifier.padding(start = 20.dp, top = 30.dp),
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.ExtraBold
    )
}