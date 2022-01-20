package com.emamagic.home.contract.redux

import com.emamagic.core.base.Reducer
import com.emamagic.core.utils.exhaustive
import com.emamagic.home.contract.HomeEvent
import com.emamagic.home.contract.HomeState

class HomeReducer : Reducer<HomeState, HomeEvent> {

    override fun reduce(currentState: HomeState, event: HomeEvent): HomeState {

        return when (event) {
            is HomeEvent.GetSliders -> currentState.copy(sliders = event.sliders)
            else -> currentState
        }

    }
}