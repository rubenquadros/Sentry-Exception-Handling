package com.ruben.exceptioncatcher.compose.debug

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import com.ruben.exceptioncatcher.BuildConfig

/**
 * Created by Ruben Quadros on 12/06/22
 **/
class Ref(var value: Int)

const val APP_NAME = "ExceptionCatcher"

@Suppress("NOTHING_TO_INLINE")
@Composable
inline fun LogCompositions(tag: String) {
    if (BuildConfig.DEBUG) {
        val ref = remember { Ref(0) }
        SideEffect { ref.value++ }
        Log.d(APP_NAME, "Compositions: $tag ${ref.value}")
    }
}