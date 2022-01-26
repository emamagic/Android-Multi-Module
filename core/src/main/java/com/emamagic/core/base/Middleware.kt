package com.emamagic.core.base

import com.emamagic.common_jvm.ErrorEntity
import com.emamagic.common_jvm.NoInternetException
import com.emamagic.common_jvm.ResultWrapper
import com.emamagic.common_jvm.succeeded
import com.emamagic.core.utils.Logger

abstract class Middleware<STATE : State, ACTION : Action> {

    abstract suspend fun process(
        action: ACTION,
        currentState: STATE,
        store: Store<STATE, ACTION>,
    )


    suspend fun <T> ResultWrapper<T>.manageResult(store: Store<STATE, ACTION>): T? {
        if (!succeeded) {
            if (error is ErrorEntity.Network) store.setEffect(BaseEffect.NavigateToNoInternetDialog)
            else store.setEffect(BaseEffect.ShowToast(error?.message ?: "unKnown error"))
            Logger.e("Error Happened", error?.message)
            return null
        }
        return data
    }

}
