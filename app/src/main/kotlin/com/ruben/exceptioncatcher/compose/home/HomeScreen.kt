package com.ruben.exceptioncatcher.compose.home

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.ruben.exceptioncatcher.R
import com.ruben.exceptioncatcher.compose.debug.LogCompositions

/**
 * Created by Ruben Quadros on 12/06/22
 **/
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    LogCompositions(tag = "HomeScreen")

    val context = LocalContext.current
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    LaunchedEffect(homeViewModel, lifecycle) {
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            homeViewModel.homeState.collect {
                it.errorMessage?.let { message ->
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                    homeViewModel.errorMessageShown()
                }
            }
        }
    }

    HomeScreenContent(
        handleException = homeViewModel::handleException,
        unhandledException = homeViewModel::unhandledException
    )
}

@Composable
private fun HomeScreenContent(
    handleException: () -> Unit,
    unhandledException: () -> Unit
) {
    LogCompositions(tag = "HomeScreenContent")

    Column(modifier = Modifier.fillMaxSize()) {

        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = handleException
        ) {
            Text(text = stringResource(id = R.string.handled_exception))
        }

        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = unhandledException
        ) {
            Text(text = stringResource(id = R.string.unhandled_exception))
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeScreenContent() {
    HomeScreenContent(
        handleException = {},
        unhandledException = {}
    )
}