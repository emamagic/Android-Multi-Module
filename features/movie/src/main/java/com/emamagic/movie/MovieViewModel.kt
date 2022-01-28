package com.emamagic.movie

import com.emamagic.core.base.BaseViewModelRedux
import com.emamagic.movie.contract.MovieAction
import com.emamagic.movie.contract.MovieState
import com.emamagic.movie.contract.redux.MovieStore
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val store: MovieStore
): BaseViewModelRedux<MovieState, MovieAction>(store) {


    override fun getInitialFunctions(): List<suspend () -> Unit> =
        emptyList()


}