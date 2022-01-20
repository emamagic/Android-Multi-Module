package com.emamagic.home.contract.redux

import com.emamagic.common_jvm.succeeded
import com.emamagic.core.base.BaseEffect
import com.emamagic.core.base.Middleware
import com.emamagic.core.base.Store
import com.emamagic.core.interactor.HomeUseCase
import com.emamagic.home.contract.HomeEvent
import com.emamagic.home.contract.HomeState
import javax.inject.Inject

class HomeDataMiddleware @Inject constructor(
    private val homeUseCase: HomeUseCase
) : Middleware<HomeState, HomeEvent> {

    override suspend fun process(
        event: HomeEvent,
        currentState: HomeState,
        store: Store<HomeState, HomeEvent>
    ) {
        when (event) {
           is HomeEvent.GetGenre -> fetchSliders(store)
        }
    }

    private suspend fun fetchSliders(store: Store<HomeState, HomeEvent>) {
        store.setEffect(BaseEffect.ShowLoading())
        val result = homeUseCase.getSliders()
        if (result.succeeded) {
            store.dispatch(HomeEvent.GetSliders(result.data!!))
        } else {
            store.setEffect(BaseEffect.ShowToast(result.error?.message ?: "unKnown error"))
        }
        store.setEffect(BaseEffect.HideLoading)
    }



}

