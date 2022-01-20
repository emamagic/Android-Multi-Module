package com.emamagic.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.emamagic.common_jvm.ResultWrapper
import com.emamagic.common_jvm.succeeded
import com.emamagic.core.utils.AlertType
import com.emamagic.core.utils.Logger
import com.emamagic.core.utils.ToastyMode
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModelRedux<STATE : State, EVENT : Event, STORE : Store<STATE, EVENT>>
    : ViewModel() {

    abstract fun createStore(): STORE
    private val store: Store<STATE, EVENT> by lazy { createStore() }
    val viewState: StateFlow<STATE> = store.state

    val currentState: STATE
        get() = viewState.value

//    private val _uiEvent: MutableSharedFlow<EVENT> = MutableSharedFlow()
//    val uiEvent = _uiEvent.asSharedFlow()
//
//    private val _uiEffect: Channel<BaseEffect> = Channel()
//    val uiEffect = _uiEffect.receiveAsFlow()

//    fun setEvent(event: EVENT) {
//        val newEvent = event
//        viewModelScope.launch { _uiEvent.emit(newEvent) }
//    }

    protected fun setState(reduce: STATE.() -> STATE) {
        val newState = currentState.reduce()
       // _uiState.value = newState
    }

//    protected fun setEffect(builder: () -> BaseEffect) {
//        val effectValue = builder()
//        viewModelScope.launch { _uiEffect.send(effectValue) }
//    }


    init {
       // subscribeEvents()
    }

//    private fun subscribeEvents() = viewModelScope.launch {
//        uiEvent.collect {
//          //  handleEvent(it)
//        }
//    }

//    abstract fun handleEvent(event: EVENT)

//    fun navigateTo(directions: NavDirections) {
//        setEffect { BaseEffect.NavigateTo(directions) }
//    }
//
//    fun navigateBack() {
//        setEffect { BaseEffect.NavigateBack }
//    }
//
//    fun showToast(
//        message: String,
//        @ToastyMode mode: Int = ToastyMode.MODE_TOAST_DEFAULT
//    ) {
//        setEffect { BaseEffect.ShowToast(message, mode) }
//    }

//    fun showAlert(
//        message: String,
//        accept: String?,
//        decline: String?,
//        @AlertType alertType: Int,
//        canBeDismiss: Boolean = false,
////        val action: BaseFragment.DialogListener? = null
//    ) {
//        setEffect { BaseEffect.ShowAlert(message, accept, decline, alertType, canBeDismiss) }
//    }
//
//    fun showLoading(isDime: Boolean = false) {
//        setEffect { BaseEffect.ShowLoading(isDime) }
//    }
//
//    fun hideLoading() {
//        setEffect { BaseEffect.HideLoading }
//    }
//
//
//    fun <T> ResultWrapper<T>.manageResult(): T? {
////        hideLoading()
//        if (!succeeded) {
//            showToast(error?.message ?: "unKnown error")
//            Logger.e("Error Happened", error?.message)
//            return null
//        }
//        return data
//    }


}