package com.emamagic.home.contract

import com.emamagic.common_entity.Slider
import com.emamagic.common_jvm.GenreCategory
import com.emamagic.core.base.Event
import com.emamagic.common_jvm.MovieCategory
import com.emamagic.common_jvm.ResultWrapper

sealed class HomeEvent: Event {
    data class GetSliders(var sliders: List<Slider>): HomeEvent()
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