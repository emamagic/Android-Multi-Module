package com.emamagic.core.base

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow

open class BaseStore<STATE : State, ACTION : Action>(
    initialState: STATE,
    private val reducer: Reducer<STATE, ACTION>,
    private val middlewares: List<Middleware<STATE, ACTION>> = emptyList(),
) : Store<STATE, ACTION> {

    private val _state = MutableStateFlow(initialState)
    override val state: StateFlow<STATE> = _state

    private val _effect : Channel<BaseEffect> = Channel()
    override val effect = _effect

    private val currentState: STATE
        get() = _state.value

    override suspend fun dispatch(action: ACTION) {
        middlewares.forEach { middleware ->
            middleware.process(action, currentState, this)
        }

        val newState = reducer.reduce(currentState, action)
        _state.value = newState
    }

    override suspend fun setEffect(effect: BaseEffect) {
        _effect.send(effect)
    }

}
