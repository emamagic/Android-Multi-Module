package com.emamagic.movie.contract.redux

import com.emamagic.core.base.Reducer
import com.emamagic.movie.contract.MovieAction
import com.emamagic.movie.contract.MovieState

class MovieReducer: Reducer<MovieState, MovieAction> {

    override fun reduce(currentState: MovieState, action: MovieAction): MovieState {
        return when (action) {
            is MovieAction.GetDetailMovie -> TODO()
            is MovieAction.GetSeasons -> TODO()
            is MovieAction.PlayVideoClicked -> TODO()
            is MovieAction.SeasonClicked -> TODO()
        }
    }
}