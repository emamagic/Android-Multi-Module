package com.emamagic.core.base

interface Middleware<STATE : State, ACTION : Action> {

    suspend fun process(
        action: ACTION,
        currentState: STATE,
        store: Store<STATE, ACTION>,
    )
}
