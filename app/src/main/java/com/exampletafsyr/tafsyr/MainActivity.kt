package com.exampletafsyr.tafsyr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.exampletafsyr.tafsyr.screens.sura.SuraListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuraListScreen()
        }
    }
}
