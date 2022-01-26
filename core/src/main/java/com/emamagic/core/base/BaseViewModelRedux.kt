package com.emamagic.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.*

/** events are normal fun and states are stream */
abstract class BaseViewModelRedux<STATE : State, ACTION : Action> constructor(
    store: Store<STATE, ACTION>
) : ViewModel() {

    val viewState: StateFlow<STATE> = store.state

    val currentState: STATE
        get() = viewState.value

//    private val _uiEvent: MutableSharedFlow<ACTION> = MutableSharedFlow()
//    val uiEvent = _uiEvent.asSharedFlow()

    val uiEffect = store.effect.receiveAsFlow()

//    fun setEvent(event: ACTION) {
//        val newEvent = event
//        viewModelScope.launch { _uiEvent.emit(newEvent) }
//    }
//
//    protected fun setEffect(builder: () -> BaseEffect) {
//        val effectValue = builder()
//        viewModelScope.launch { store.effect.send(effectValue) }
//    }
//
//
//    init {
//        subscribeEvents()
//    }
//
//    private fun subscribeEvents() = viewModelScope.launch {
//        uiEvent.collect {
//            store.dispatch(it)
//        }
//    }
//
//
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
//
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


}