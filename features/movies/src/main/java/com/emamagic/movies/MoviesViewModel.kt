package com.emamagic.movies

import androidx.lifecycle.viewModelScope
import com.emamagic.common_jvm.MovieCategory
import com.emamagic.core.base.BaseViewModel
import com.emamagic.core.interactor.MoviesUseCase
import com.emamagic.core.utils.exhaustive
import com.emamagic.movies.contract.MoviesEvent
import com.emamagic.movies.contract.MoviesState
import kotlinx.coroutines.launch
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    private val moviesUseCase: MoviesUseCase
): BaseViewModel<MoviesState, MoviesEvent>() {

    override fun createInitialState(): MoviesState = MoviesState.initialize()

    override fun handleEvent(event: MoviesEvent) {
        when (event) {
            is MoviesEvent.GetMovies -> getMoviesByCategory(event.category)
        }.exhaustive
    }


    private fun getMoviesByCategory(@MovieCategory category: String) = viewModelScope.launch {
        moviesUseCase.getMoviesByMovieCategory(category).manageResult()
    }


}