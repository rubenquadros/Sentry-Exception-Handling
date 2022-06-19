package com.ruben.exceptioncatcher.compose

import androidx.navigation.NavHostController

/**
 * Created by Ruben Quadros on 12/06/22
 **/
object Destinations {
    const val Home = "home"
    const val Error = "error"
}

class NavGraph(navHostController: NavHostController) {

    val openErrorScreen: () -> Unit = {
        navHostController.navigate(route = Destinations.Error)
    }

    val openHomeScreen: () -> Unit = {
        navHostController.navigate(route = Destinations.Home) {
            popUpTo(navHostController.graph.startDestinationId) {
                inclusive = true
            }
        }
    }
}