package com.ruben.exceptioncatcher.compose.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruben.exceptioncatcher.base.CustomException
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created by Ruben Quadros on 12/06/22
 **/
@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {

    private val _homeState: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
    val homeState: StateFlow<HomeState> = _homeState.asStateFlow()

    fun handleException() {
        viewModelScope.launch {
            runCatching {
                doWork()
            }.onFailure {
                _homeState.update {
                    it.copy(errorMessage = "Something went wrong")
                }
            }
        }
    }

    fun unhandledException() {
        viewModelScope.launch {
            doWork()
        }
    }

    fun errorMessageShown() {
        _homeState.update {
            it.copy(errorMessage = null)
        }
    }

    private fun doWork() {
        throw CustomException()
    }

}