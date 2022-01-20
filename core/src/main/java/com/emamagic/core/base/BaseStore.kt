package com.emamagic.core.base

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow

open class BaseStore<STATE : State, EVENT : Event>(
    initialState: STATE,
    private val reducer: Reducer<STATE, EVENT>,
    private val middlewares: List<Middleware<STATE, EVENT>> = emptyList(),
) : Store<STATE, EVENT> {

    private val _state = MutableStateFlow(initialState)
    override val state: StateFlow<STATE> = _state

    private val _effect : Channel<BaseEffect> = Channel()
    override val effect = _effect.receiveAsFlow()

    private val currentState: STATE
        get() = _state.value

    override suspend fun dispatch(event: EVENT) {
        middlewares.forEach { middleware ->
            middleware.process(event, currentState, this)
        }

        val newState = reducer.reduce(currentState, event)
        _state.value = newState
    }

    override suspend fun setEffect(effect: BaseEffect) {
        _effect.send(effect)
    }

}
