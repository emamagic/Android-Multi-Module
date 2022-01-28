package com.emamagic.movie.contract.redux

import com.emamagic.core.base.BaseStore
import com.emamagic.movie.contract.MovieAction
import com.emamagic.movie.contract.MovieState
import javax.inject.Inject

class MovieStore @Inject constructor(
    movieMiddleware: MovieMiddleware
): BaseStore<MovieState, MovieAction>(
    initialState = MovieState.initialize(),
    reducer = MovieReducer(),
    middlewares = listOf(
        movieMiddleware
    )
)