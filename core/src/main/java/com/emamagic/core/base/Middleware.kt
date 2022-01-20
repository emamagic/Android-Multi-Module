package com.emamagic.core.base

interface Middleware<STATE : State, EVENT : Event> {

    suspend fun process(
        event: EVENT,
        currentState: STATE,
        store: Store<STATE, EVENT>,
    )
}
