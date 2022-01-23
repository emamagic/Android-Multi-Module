package com.emamagic.home.contract

import com.emamagic.common_entity.Genre
import com.emamagic.common_entity.Movie
import com.emamagic.common_entity.Slider
import com.emamagic.common_jvm.MovieCategory
import com.emamagic.core.base.State

data class HomeState(
    val sliders: List<Slider>,
    val genres: List<Genre>,
    val topImdbMovies: List<Movie>,
    val popularMovies: List<Movie>,
    val animations: List<Movie>,
    val series: List<Movie>
) : State {
    companion object {
        fun initialize() = HomeState(
            sliders = emptyList(),
            genres = emptyList(),
            topImdbMovies = emptyList(),
            popularMovies = emptyList(),
            animations = emptyList(),
            series = emptyList()
        )
    }
}