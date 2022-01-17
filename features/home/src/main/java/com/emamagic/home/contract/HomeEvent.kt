package com.emamagic.home.contract

import com.emamagic.core.base.BaseEvent
import com.emamagic.home.CategoryType

sealed class HomeEvent: BaseEvent {
    object GetSliders: HomeEvent()
    object GetMovies: HomeEvent()
    object GetGenre: HomeEvent()
    object ShouldCloseApp: HomeEvent()
    object SearchClicked: HomeEvent()
    data class MoreMovieClicked(@CategoryType val categoryType: String): HomeEvent()
//    data class MovieClicked(val movie: MovieEntity): HomeEvent()
    data class GenreClicked(val genreName: String): HomeEvent()
    object SwipeRefreshed: HomeEvent()
    object FavoriteClicked: HomeEvent()
}