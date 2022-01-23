package com.emamagic.home.contract.redux

import com.emamagic.common_jvm.MovieCategory
import com.emamagic.core.base.Reducer
import com.emamagic.core.utils.exhaustive
import com.emamagic.home.contract.HomeAction
import com.emamagic.home.contract.HomeState

class HomeReducer : Reducer<HomeState, HomeAction> {

    override fun reduce(currentState: HomeState, action: HomeAction): HomeState {

        return when (action) {
            is HomeAction.SlidersLoaded -> currentState.copy(sliders = action.sliders)
            is HomeAction.MoviesLoaded -> {
                when (action.category) {
                    MovieCategory.POPULAR -> currentState.copy(popularMovies = action.movies)
                    MovieCategory.TOP_IMDB -> currentState.copy(topImdbMovies = action.movies)
                    MovieCategory.SERIES -> currentState.copy(series = action.movies)
                    MovieCategory.ANIMATION -> currentState.copy(animations = action.movies)
                    else -> TODO()
                }.exhaustive
            }
            is HomeAction.GenreLoaded -> currentState.copy(genres = action.genres)
            else -> currentState
        }

    }
}