package com.emamagic.home.contract.redux

import com.emamagic.common_jvm.MovieCategory
import com.emamagic.core.base.HomeEffect
import com.emamagic.core.base.Middleware
import com.emamagic.core.base.Store
import com.emamagic.core.interactor.HomeUseCase
import com.emamagic.home.contract.HomeAction
import com.emamagic.home.contract.HomeState
import kotlinx.coroutines.delay
import javax.inject.Inject

class HomeMiddleware @Inject constructor(
    private val homeUseCase: HomeUseCase
) : Middleware<HomeState, HomeAction>() {

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
        homeUseCase.getSliders().manageResult(store)?.let {
            store.dispatch(HomeAction.SlidersLoaded(it))
        }
        // waiting for recyclerViews load items completely
        delay(1500)
        store.setEffect(HomeEffect.StopShimmer)
    }

    private suspend fun fetchGenre(store: Store<HomeState, HomeAction>) {
        homeUseCase.getGenre().manageResult(store)?.let {
            store.dispatch(HomeAction.GenreLoaded(it))
        }
    }

    private suspend fun fetchMovies(store: Store<HomeState, HomeAction>, @MovieCategory category: String) {
        homeUseCase.getMoviesByMovieCategory(category).manageResult(store)?.let {
            store.dispatch(HomeAction.MoviesLoaded(category, it))
        }
    }


}

