package com.ruben.exceptioncatcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.ruben.exceptioncatcher.base.captureException
import com.ruben.exceptioncatcher.base.theme.ExceptionCatcherTheme
import com.ruben.exceptioncatcher.compose.ExceptionCatcherApp
import dagger.hilt.android.AndroidEntryPoint
import io.sentry.Sentry

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    private val exceptionHandler =
        Thread.UncaughtExceptionHandler { _: Thread, e: Throwable -> handleUncaughtException(e) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExceptionCatcherTheme {
                ExceptionCatcherApp(mainViewModel)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        attachUnhandledExceptionHandler()
    }

    override fun onStop() {
        detachUnhandledExceptionHandler()
        super.onStop()
    }

    private fun attachUnhandledExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler(exceptionHandler)
//        if (BuildConfig.DEBUG.not()) {
//            Thread.setDefaultUncaughtExceptionHandler(exceptionHandler)
//        }
    }

    private fun detachUnhandledExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler(null)
//        if (BuildConfig.DEBUG.not()) {
//            Thread.setDefaultUncaughtExceptionHandler(null)
//        }
    }

    private fun handleUncaughtException(e: Throwable) {
        e.captureException()
        mainViewModel.handleUnknownException()
    }
}