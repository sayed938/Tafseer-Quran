package com.exampletafsyr.tafsyr

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.exampletafsyr.tafsyr.routes.ayaRoute
import com.exampletafsyr.tafsyr.routes.homeRoute
import com.exampletafsyr.tafsyr.routes.suraRoute
import com.exampletafsyr.tafsyr.routes.tafsyrRoute

@Composable
fun AyaNAvGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "homeScreen") {
        homeRoute(navController)
        suraRoute(navController)
        ayaRoute(navController)
        tafsyrRoute(navController)
    }

}