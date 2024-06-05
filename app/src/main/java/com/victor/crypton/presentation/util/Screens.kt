package com.victor.crypton.presentation.util

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.victor.crypton.presentation.HomeScreen
import com.victor.crypton.presentation.HomeViewModel
import com.victor.crypton.presentation.LandingScreen
import com.victor.crypton.presentation.RegistrationScreen

enum class Screens(
    val route: String,
    val composable: @Composable (NavController) -> Unit
) {
    LANDING(
        route = "landing",
        composable = { navController ->
            LandingScreen(
                navController = navController
            )
        }
    ),
    REGISTRATION(
        route = "registration",
        composable = { navController ->
            RegistrationScreen(navController = navController)
        }
    ),
    HOME(
        route = "home",
        composable = { navController ->
            HomeScreen(
                navController = navController,
                homeViewModel = hiltViewModel<HomeViewModel>()
            )
        }
    )
}