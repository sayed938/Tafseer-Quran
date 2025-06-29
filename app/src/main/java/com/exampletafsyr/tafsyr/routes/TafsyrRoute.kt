package com.exampletafsyr.tafsyr.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.exampletafsyr.tafsyr.screens.tafsyr.TafsyrScreen

private const val ROUTE = "tafsyrScreen"
fun NavGraphBuilder.tafsyrRoute(navController: NavController) {
    composable("${ROUTE}") { TafsyrScreen() }

}