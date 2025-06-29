package com.exampletafsyr.tafsyr.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.exampletafsyr.tafsyr.screens.sura.SuraListScreen

private const val ROUTE = "suraListScreen"
fun NavGraphBuilder.suraRoute(navController: NavController) {
    composable("${ROUTE}") { SuraListScreen() }

}