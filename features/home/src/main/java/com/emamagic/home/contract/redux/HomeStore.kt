package com.emamagic.home.contract.redux

import com.emamagic.core.base.BaseStore
import com.emamagic.home.contract.HomeAction
import com.emamagic.home.contract.HomeState
import javax.inject.Inject

class HomeStore @Inject constructor(
    homeNetworkMiddleware: HomeNetworkMiddleware
) : BaseStore<HomeState, HomeAction>(
    initialState = HomeState.initialize(),
    reducer = HomeReducer(),
    middlewares = listOf(
        homeNetworkMiddleware
    )
)