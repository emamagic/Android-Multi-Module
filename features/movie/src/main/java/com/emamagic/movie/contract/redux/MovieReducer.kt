package com.emamagic.movie.contract.redux

import com.emamagic.core.base.Reducer
import com.emamagic.movie.contract.MovieAction
import com.emamagic.movie.contract.MovieState

class MovieReducer: Reducer<MovieState, MovieAction> {

    override fun reduce(currentState: MovieState, action: MovieAction): MovieState {
        return when (action) {
            is MovieAction.MovieDetailLoaded -> currentState.copy(movie = action.movieDetail)
            is MovieAction.CastsLoaded -> currentState.copy(casts = action.casts)
            is MovieAction.SeasonsLoaded -> currentState.copy(season = action.seasons)
            else -> currentState
        }
    }
}