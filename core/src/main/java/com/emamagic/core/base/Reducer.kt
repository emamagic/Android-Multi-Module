package com.emamagic.core.base

interface Reducer<S : State, E : Event> {

    fun reduce(currentState: S, event: E): S
}
