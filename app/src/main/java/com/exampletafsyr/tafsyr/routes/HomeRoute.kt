package com.exampletafsyr.tafsyr.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.exampletafsyr.tafsyr.PassArgsSharedViewM
import com.exampletafsyr.tafsyr.screens.home.HomeScreen

private const val ROUTE = "homeScreen"
fun NavGraphBuilder.homeRoute(navController: NavController, sharedViewM: PassArgsSharedViewM) {
    composable("${ROUTE}") { HomeScreen(navController, sharedViewM) }

}