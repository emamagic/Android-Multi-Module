package com.emamagic.home

import com.emamagic.core.base.BaseViewModel
import com.emamagic.core.utils.exhaustive
import com.emamagic.home.contract.HomeEvent
import com.emamagic.home.contract.HomeState
import javax.inject.Inject

class HomeViewModel @Inject constructor(
): BaseViewModel<HomeState, HomeEvent>() {

    override fun createInitialState(): HomeState = HomeState.initialize()

    override fun handleEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.FavoriteClicked -> TODO()
            is HomeEvent.GenreClicked -> TODO()
            HomeEvent.GetGenre -> TODO()
            HomeEvent.GetMovies -> TODO()
            HomeEvent.GetSliders -> TODO()
            is HomeEvent.MoreMovieClicked -> TODO()
            HomeEvent.SearchClicked -> TODO()
            HomeEvent.ShouldCloseApp -> TODO()
            HomeEvent.SwipeRefreshed -> TODO()
        }.exhaustive
    }
}