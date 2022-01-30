package com.emamagic.movie

import androidx.lifecycle.viewModelScope
import com.emamagic.core.base.BaseViewModelRedux
import com.emamagic.movie.contract.MovieAction
import com.emamagic.movie.contract.MovieState
import com.emamagic.movie.contract.redux.MovieStore
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val store: MovieStore
): BaseViewModelRedux<MovieState, MovieAction>(store) {

    override fun getInitialFunctions(): List<suspend () -> Unit> =
        emptyList()


    fun getMovieDetailEvent(movieId: String) = viewModelScope.launch {
        store.dispatch(MovieAction.GetMovieDetail(movieId))
    }

    fun getSeasonsEvent(movieId: String) = viewModelScope.launch {
        store.dispatch(MovieAction.GetSeasons(movieId))
    }

    fun getCastsEvent(movieId: String) = viewModelScope.launch {
        store.dispatch(MovieAction.GetCasts(movieId))
    }

    fun playButtonClickEvent(videoLink: String) = viewModelScope.launch {
        // navigate
    }

}