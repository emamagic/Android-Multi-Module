package com.emamagic.home.contract.redux

import com.emamagic.core.base.Reducer
import com.emamagic.home.contract.HomeAction
import com.emamagic.home.contract.HomeState

class HomeReducer : Reducer<HomeState, HomeAction> {

    override fun reduce(currentState: HomeState, action: HomeAction): HomeState {

        return when (action) {
            is HomeAction.SlidersLoaded -> currentState.copy(sliders = action.sliders)
            is HomeAction.MoviesLoaded -> currentState.copy(movieCategory = action.category, movies = action.movies)
            is HomeAction.GenreLoaded -> currentState.copy(genres = action.genres)
            else -> currentState
        }

    }
}