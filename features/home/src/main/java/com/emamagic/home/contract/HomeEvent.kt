package com.emamagic.home.contract

import com.emamagic.common_jvm.GenreCategory
import com.emamagic.core.base.BaseEvent
import com.emamagic.common_jvm.MovieCategory

sealed class HomeEvent: BaseEvent {
    object GetSliders: HomeEvent()
    object GetMovies: HomeEvent()
    object GetGenre: HomeEvent()
    object ShouldCloseApp: HomeEvent()
    object SearchClicked: HomeEvent()
    data class MoreMovieClicked(@MovieCategory val category: String): HomeEvent()
//    data class MovieClicked(val movie: MovieEntity): HomeEvent()
    data class GenreClicked(@GenreCategory val category: String): HomeEvent()
    object SwipeRefreshed: HomeEvent()
    object FavoriteClicked: HomeEvent()
}