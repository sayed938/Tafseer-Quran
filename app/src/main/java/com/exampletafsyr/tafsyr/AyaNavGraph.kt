package com.exampletafsyr.tafsyr

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.exampletafsyr.tafsyr.routes.ayaRoute
import com.exampletafsyr.tafsyr.routes.homeRoute
import com.exampletafsyr.tafsyr.routes.suraRoute
import com.exampletafsyr.tafsyr.routes.tafsyrRoute

@Composable
fun AyaNAvGraph(navController: NavHostController) {
    val sharedVM: PassArgsSharedViewM= hiltViewModel()
    NavHost(navController = navController, startDestination = "homeScreen") {
        homeRoute(navController,sharedVM)
        suraRoute(navController,sharedVM)
        ayaRoute(navController,sharedVM)
        tafsyrRoute(navController,sharedVM)
    }

}