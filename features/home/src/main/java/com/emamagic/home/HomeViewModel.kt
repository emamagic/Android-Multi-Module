package com.emamagic.home

import androidx.lifecycle.viewModelScope
import com.emamagic.common_jvm.MovieCategory
import com.emamagic.core.base.BaseViewModel
import com.emamagic.core.interactor.HomeUseCase
import com.emamagic.core.utils.exhaustive
import com.emamagic.home.contract.HomeEvent
import com.emamagic.home.contract.HomeState
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
): BaseViewModel<HomeState, HomeEvent>() {

    init {
        getSliders()
        getMoviesByCategory(MovieCategory.TOP_IMDB)
        getMoviesByCategory(MovieCategory.POPULAR)
        getMoviesByCategory(MovieCategory.ANIMATION)
        getMoviesByCategory(MovieCategory.SERIES)
    }

    override fun createInitialState(): HomeState = HomeState.initialize()

    override fun handleEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.FavoriteClicked -> TODO()
            is HomeEvent.GenreClicked -> TODO()
            HomeEvent.GetGenre -> TODO()
            HomeEvent.GetMovies -> TODO()
            HomeEvent.GetSliders -> TODO()
            is HomeEvent.MoreMovieClicked -> TODO()
            HomeEvent.SearchClicked -> TODO()
            HomeEvent.ShouldCloseApp -> TODO()
            HomeEvent.SwipeRefreshed -> TODO()
        }.exhaustive
    }

    private fun getSliders() = viewModelScope.launch {
        homeUseCase.getSliders().manageResult()?.let { sliders ->
            setState { copy(sliders = sliders) }
        }
    }

    private fun getMoviesByCategory(@MovieCategory category: String) = viewModelScope.launch {
        homeUseCase.getMoviesByMovieCategory(category).manageResult()?.let { movies ->
            when (category) {
                MovieCategory.TOP_IMDB -> setState { copy(topImdbMovies = movies) }
                MovieCategory.POPULAR -> setState { copy(popularMovies = movies) }
                MovieCategory.ANIMATION -> setState { copy(animation = movies) }
                MovieCategory.SERIES -> setState { copy(series = movies) }
            }
        }
    }


}