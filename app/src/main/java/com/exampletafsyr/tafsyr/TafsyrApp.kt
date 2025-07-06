package com.exampletafsyr.tafsyr

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.exampletafsyr.tafsyr.navigation.AyaNAvGraph
import com.exampletafsyr.tafsyr.ui.theme.TafsyrTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TafsyrApp() {
    TafsyrTheme {
        Scaffold {
            val navController = rememberNavController()
            AyaNAvGraph(navController)
        }
    }
}