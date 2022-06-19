package com.ruben.exceptioncatcher.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ruben.exceptioncatcher.MainViewModel
import com.ruben.exceptioncatcher.compose.debug.LogCompositions
import com.ruben.exceptioncatcher.compose.error.ErrorScreen
import com.ruben.exceptioncatcher.compose.home.HomeScreen

/**
 * Created by Ruben Quadros on 12/06/22
 **/
@Composable
fun ExceptionCatcherApp(mainViewModel: MainViewModel) {

    LogCompositions(tag = "ExceptionCatcherApp")

    val navController = rememberNavController()
    val navGraph = remember(navController) { NavGraph(navController) }

    val lifecycle = LocalLifecycleOwner.current.lifecycle

    LaunchedEffect(mainViewModel, lifecycle) {
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            mainViewModel.mainState.collect {
                if (it.isUnknownException) {
                    navGraph.openErrorScreen()
                    mainViewModel.unknownExceptionHandled()
                }
            }
        }
    }

    NavHost(navController = navController, startDestination = Destinations.Home) {

        composable(route = Destinations.Home) {
            HomeScreen()
        }

        composable(route = Destinations.Error) {
            ErrorScreen(
                navigateToHome = navGraph.openHomeScreen
            )
        }
    }
}