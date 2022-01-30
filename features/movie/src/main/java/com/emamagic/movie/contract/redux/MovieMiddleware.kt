package com.emamagic.movie.contract.redux

import com.emamagic.core.base.BaseEffect
import com.emamagic.core.base.Middleware
import com.emamagic.core.base.Store
import com.emamagic.core.interactor.MovieUseCase
import com.emamagic.movie.contract.MovieAction
import com.emamagic.movie.contract.MovieState
import kotlinx.coroutines.delay
import javax.inject.Inject

class MovieMiddleware @Inject constructor(
    private val movieUseCase: MovieUseCase
): Middleware<MovieState, MovieAction>() {


    override suspend fun process(
        action: MovieAction,
        currentState: MovieState,
        store: Store<MovieState, MovieAction>
    ) {
        when (action) {
            is MovieAction.GetMovieDetail -> fetchMovieDetail(action.movieId, store)
            is MovieAction.GetCasts -> fetchCasts(action.movieId, store)
            is MovieAction.GetSeasons -> fetchSeasons(action.movieId, store)
        }
    }

    private suspend fun fetchMovieDetail(movieId: String, store: Store<MovieState, MovieAction>) {
        movieUseCase.getMovieDetail(movieId).manageResult(store)?.let {
            store.dispatch(MovieAction.MovieDetailLoaded(it))
        }
    }

    private suspend fun fetchSeasons(movieId: String, store: Store<MovieState, MovieAction>) {
        movieUseCase.getSeasons(movieId).manageResult(store)?.let {
            store.dispatch(MovieAction.SeasonsLoaded(it))
        }
    }

    private suspend fun fetchCasts(movieId: String, store: Store<MovieState, MovieAction>) {
        movieUseCase.getCasts(movieId).manageResult(store)?.let {
            store.dispatch(MovieAction.CastsLoaded(it))
            // dummy delay
            delay(1500)
            store.setEffect(BaseEffect.HideLoading)
        }
    }

}