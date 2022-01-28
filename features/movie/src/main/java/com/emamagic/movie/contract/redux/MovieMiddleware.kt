package com.emamagic.movie.contract.redux

import com.emamagic.core.base.Middleware
import com.emamagic.core.base.Store
import com.emamagic.core.interactor.MovieUseCase
import com.emamagic.movie.contract.MovieAction
import com.emamagic.movie.contract.MovieState
import javax.inject.Inject

class MovieMiddleware @Inject constructor(
    private val movieUseCase: MovieUseCase
): Middleware<MovieState, MovieAction>() {


    override suspend fun process(
        action: MovieAction,
        currentState: MovieState,
        store: Store<MovieState, MovieAction>
    ) {

    }


}