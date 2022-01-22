package com.emamagic.home.contract

import com.emamagic.common_entity.Genre
import com.emamagic.common_entity.Movie
import com.emamagic.common_entity.Slider
import com.emamagic.common_jvm.MovieCategory
import com.emamagic.core.base.State

data class HomeState(
    val sliders: List<Slider>,
    val genres: List<Genre>,
    val movies: List<Movie>,
    @MovieCategory val movieCategory: String
) : State {
    companion object {
        fun initialize() = HomeState (
            sliders = emptyList(),
            genres = emptyList(),
            movies = emptyList(),
            movieCategory = MovieCategory.TOP_IMDB
        )
    }
}