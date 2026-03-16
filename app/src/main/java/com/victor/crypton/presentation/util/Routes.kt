package com.victor.crypton.presentation.util

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {

    @Serializable
    object Landing : Routes(), NavKey

    @Serializable
    object Registration : Routes(), NavKey


    @Serializable
    object Home : Routes(), NavKey
}
