package com.exampletafsyr.tafsyr.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.exampletafsyr.tafsyr.PassArgsSharedViewM
import com.exampletafsyr.tafsyr.screens.aya.AyahListScreen

private const val ROUTE = "ayaListScreen"
fun NavGraphBuilder.ayaRoute(navController: NavController,sharedVM: PassArgsSharedViewM) {
    composable("${ROUTE}") { AyahListScreen(navController,sharedVM) }

}