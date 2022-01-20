package com.emamagic.core.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface Store<STATE : State, EVENT : Event> {

    val state: StateFlow<STATE>
    val effect: Flow<BaseEffect>

    suspend fun dispatch(event: EVENT)

    suspend fun setEffect(effect: BaseEffect)

}
