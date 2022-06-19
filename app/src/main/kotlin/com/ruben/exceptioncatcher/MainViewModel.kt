package com.ruben.exceptioncatcher

import androidx.lifecycle.ViewModel
import com.ruben.exceptioncatcher.compose.MainState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Created by Ruben Quadros on 12/06/22
 **/
class MainViewModel: ViewModel() {

    private val _mainState: MutableStateFlow<MainState> = MutableStateFlow(MainState())
    val mainState: StateFlow<MainState> = _mainState.asStateFlow()

    fun handleUnknownException() {
        _mainState.update {
            it.copy(isUnknownException = true)
        }
    }

    fun unknownExceptionHandled() {
        _mainState.update {
            it.copy(isUnknownException = false)
        }
    }

}