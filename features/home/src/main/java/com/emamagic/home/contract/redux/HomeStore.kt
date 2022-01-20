package com.emamagic.home.contract.redux

import com.emamagic.core.base.BaseStore
import com.emamagic.home.contract.HomeEvent
import com.emamagic.home.contract.HomeState
import javax.inject.Inject

class HomeStore @Inject constructor(
    homeDataMiddleware: HomeDataMiddleware
) : BaseStore<HomeState, HomeEvent>(
    initialState = HomeState.initialize(),
    reducer = HomeReducer(),
    middlewares = listOf(
        homeDataMiddleware
    )
)