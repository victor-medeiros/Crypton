package com.victor.crypton.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
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
                navController = navController
            )
        }
    )
}