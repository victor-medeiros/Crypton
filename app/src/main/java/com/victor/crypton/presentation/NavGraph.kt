package com.victor.crypton.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.victor.crypton.presentation.util.Screens

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.LANDING.route) {
        Screens.entries.forEach { screen ->
            composable(screen.route) {
                screen.composable(navController)
            }
        }
    }
}