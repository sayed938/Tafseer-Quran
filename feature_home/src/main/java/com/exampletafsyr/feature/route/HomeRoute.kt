package com.exampletafsyr.feature.route

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.exampletafsyr.feature.home.HomeScreen
import com.exampletafsyr.core.shared.PassArgsSharedViewM

private const val ROUTE = "homeScreen"
fun NavGraphBuilder.homeRoute(navController: NavController, sharedViewM: PassArgsSharedViewM) {
    composable("${ROUTE}") { HomeScreen(navController, sharedViewM) }

}