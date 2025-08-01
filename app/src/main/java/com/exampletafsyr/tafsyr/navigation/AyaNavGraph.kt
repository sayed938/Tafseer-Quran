@file:Suppress("DEPRECATION")

package com.exampletafsyr.tafsyr.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.exampletafsyr.core.shared.PassArgsSharedViewM
import com.exampletafsyr.feature.route.homeRoute
import com.exampletafsyr.feature_ayah.route.ayaRoute
import com.exampletafsyr.feature_sura.route.suraRoute
import com.exampletafsyr.feature_tafseer.route.tafsyrRoute
import com.exampletafsyr.feature.route.splashRoute
import com.google.accompanist.navigation.animation.AnimatedNavHost

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AyaNAvGraph(navController: NavHostController) {
    val sharedVM: PassArgsSharedViewM = hiltViewModel()

    AnimatedNavHost(
        navController = navController,
        startDestination = "splashScreen",
        enterTransition = { fadeIn(animationSpec = tween(1000)) },
        exitTransition = { fadeOut(animationSpec = tween(500)) },
        popEnterTransition = { fadeIn(animationSpec = tween(500)) },
        popExitTransition = { fadeOut(animationSpec = tween(500)) }
    ) {
        homeRoute(navController, sharedVM)
        suraRoute(navController, sharedVM)
        ayaRoute(navController, sharedVM)
        tafsyrRoute(navController, sharedVM)
        splashRoute(navController)
    }
}
