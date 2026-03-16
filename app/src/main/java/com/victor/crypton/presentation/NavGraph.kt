package com.victor.crypton.presentation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.victor.crypton.presentation.util.Routes

@Composable
fun NavGraph() {
    val backStack = rememberNavBackStack(Routes.Landing)

    NavDisplay(
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        backStack = backStack,
        entryProvider = entryProvider {
            entry<Routes.Landing> { LandingScreen(onNext = { backStack.add(Routes.Registration) }) }
            entry<Routes.Registration> {
                RegistrationScreen(
                    onClose = { backStack.remove(Routes.Registration) },
                    onNext = { backStack.add(Routes.Home) }
                )
            }
            entry<Routes.Home> { HomeScreen() }
        }
    )
}