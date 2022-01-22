package com.emamagic.core.base

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface Store<STATE : State, ACTION : Action> {

    val state: StateFlow<STATE>
    val effect: Channel<BaseEffect>

    suspend fun dispatch(action: ACTION)

    suspend fun setEffect(effect: BaseEffect)

}
