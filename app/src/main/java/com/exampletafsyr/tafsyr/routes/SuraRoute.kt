package com.exampletafsyr.tafsyr.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.exampletafsyr.tafsyr.PassArgsSharedViewM
import com.exampletafsyr.tafsyr.screens.sura.SuraListScreen

private const val ROUTE = "suraListScreen"
fun NavGraphBuilder.suraRoute(navController: NavController,sharedVM: PassArgsSharedViewM) {
    composable("${ROUTE}") { SuraListScreen(navController,sharedVM) }

}