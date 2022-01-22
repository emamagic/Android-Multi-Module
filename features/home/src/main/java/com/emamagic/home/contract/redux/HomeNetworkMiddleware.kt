package com.emamagic.home.contract.redux

import com.emamagic.common_jvm.MovieCategory
import com.emamagic.common_jvm.succeeded
import com.emamagic.core.base.BaseEffect
import com.emamagic.core.base.Middleware
import com.emamagic.core.base.Store
import com.emamagic.core.interactor.HomeUseCase
import com.emamagic.home.contract.HomeAction
import com.emamagic.home.contract.HomeState
import javax.inject.Inject

class HomeNetworkMiddleware @Inject constructor(
    private val homeUseCase: HomeUseCase
) : Middleware<HomeState, HomeAction> {

    override suspend fun process(
        action: HomeAction,
        currentState: HomeState,
        store: Store<HomeState, HomeAction>
    ) {
        when (action) {
           is HomeAction.GetGenre -> fetchGenre(store)
            HomeAction.GetSliders -> fetchSliders(store)
            is HomeAction.GetMovies -> fetchMovies(store, action.category)
        }
    }

    private suspend fun fetchSliders(store: Store<HomeState, HomeAction>) {
        store.setEffect(BaseEffect.ShowLoading())
        val result = homeUseCase.getSliders()
        if (result.succeeded) {
            store.dispatch(HomeAction.SlidersLoaded(result.data!!))
        } else {
            store.setEffect(BaseEffect.ShowToast(result.error?.message ?: "unKnown error"))
        }
        store.setEffect(BaseEffect.HideLoading)
    }

    private suspend fun fetchGenre(store: Store<HomeState, HomeAction>) {
        store.setEffect(BaseEffect.ShowLoading())
        val result = homeUseCase.getGenre()
        if (result.succeeded) {
            store.dispatch(HomeAction.GenreLoaded(result.data!!))
        } else {
            store.setEffect(BaseEffect.ShowToast(result.error?.message ?: "unKnown error"))
        }
        store.setEffect(BaseEffect.HideLoading)
    }

    private suspend fun fetchMovies(store: Store<HomeState, HomeAction>, @MovieCategory category: String) {
        store.setEffect(BaseEffect.ShowLoading())
        val result = homeUseCase.getMoviesByMovieCategory(category)
        if (result.succeeded) {
            store.dispatch(HomeAction.MoviesLoaded(category, result.data!!))
        } else {
            store.setEffect(BaseEffect.ShowToast(result.error?.message ?: "unKnown error"))
        }
        store.setEffect(BaseEffect.HideLoading)
    }


}

