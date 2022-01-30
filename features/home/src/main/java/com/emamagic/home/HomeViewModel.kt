package com.emamagic.home

import androidx.lifecycle.viewModelScope
import com.emamagic.common_jvm.GenreCategory
import com.emamagic.common_jvm.MovieCategory
import com.emamagic.core.base.BaseEffect
import com.emamagic.core.base.BaseViewModelRedux
import com.emamagic.core.base.HomeEffect
import com.emamagic.home.contract.HomeAction
import com.emamagic.home.contract.HomeState
import com.emamagic.home.contract.redux.HomeStore
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val store: HomeStore
): BaseViewModelRedux<HomeState, HomeAction>(store) {


    init {
//        getSlidersEvent()
        getGenresEvent()
        getMoviesByCategoryEvent(MovieCategory.TOP_IMDB)
        getMoviesByCategoryEvent(MovieCategory.POPULAR)
        getMoviesByCategoryEvent(MovieCategory.ANIMATION)
        getMoviesByCategoryEvent(MovieCategory.SERIES)
    }


    override fun getInitialFunctions(): Pair<List<suspend () -> Unit>, Long> =
        Pair(
            listOf {
                store.dispatch(HomeAction.GetGenre)
                store.dispatch(HomeAction.GetMovies(MovieCategory.TOP_IMDB))
                store.dispatch(HomeAction.GetMovies(MovieCategory.POPULAR))
                store.dispatch(HomeAction.GetMovies(MovieCategory.ANIMATION))
                store.dispatch(HomeAction.GetMovies(MovieCategory.SERIES))
            },
            5000L
        )

    private fun getSlidersEvent() = viewModelScope.launch {
        store.dispatch(HomeAction.GetSliders)
    }

    private fun getGenresEvent() = viewModelScope.launch {
        store.dispatch(HomeAction.GetGenre)
    }

    private fun getMoviesByCategoryEvent(@MovieCategory category: String) = viewModelScope.launch {
        store.dispatch(HomeAction.GetMovies(category))
    }

    fun moreMovieClickEvent(@MovieCategory category: String) = viewModelScope.launch {
        store.setEffect(BaseEffect.NavigateTo(HomeFragmentDirections.actionHomeFragmentToMoviesFragment(category)))
    }

    fun moreGenreClickEvent() = viewModelScope.launch {

    }

    fun genreClickEvent(@GenreCategory category: String) = viewModelScope.launch {

    }

    private fun recyclerViewItemsLoaded() = viewModelScope.launch {
        store.setEffect(HomeEffect.StopShimmer)
    }

}