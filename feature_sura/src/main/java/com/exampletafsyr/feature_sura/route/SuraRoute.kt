package com.exampletafsyr.feature_sura.route

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.exampletafsyr.core.shared.PassArgsSharedViewM
import com.exampletafsyr.feature_sura.sura.SuraListScreen

private const val ROUTE = "suraListScreen"
fun NavGraphBuilder.suraRoute(navController: NavController,sharedVM: PassArgsSharedViewM) {
    composable("${ROUTE}") { SuraListScreen(navController,sharedVM) }

}