package com.exampletafsyr.tafsyr.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.exampletafsyr.tafsyr.screens.SplashScreen

private const val ROUTE = "splashScreen"
fun NavGraphBuilder.splashRoute(navController: NavController) {
    composable("${ROUTE}") { SplashScreen(navController) }

}