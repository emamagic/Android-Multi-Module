package com.emamagic.home.contract

import com.emamagic.common_entity.Genre
import com.emamagic.common_entity.Movie
import com.emamagic.common_entity.Slider
import com.emamagic.common_jvm.GenreCategory
import com.emamagic.common_jvm.MovieCategory
import com.emamagic.core.base.Action

sealed class HomeAction: Action {

    object GetSliders: HomeAction()
    data class SlidersLoaded(var sliders: List<Slider>): HomeAction()

    data class GetMovies(@MovieCategory var category: String): HomeAction()
    data class MoviesLoaded(@MovieCategory var category: String, var movies: List<Movie>): HomeAction()

    object GetGenre: HomeAction()
    data class GenreLoaded(var genres: List<Genre>): HomeAction()


}