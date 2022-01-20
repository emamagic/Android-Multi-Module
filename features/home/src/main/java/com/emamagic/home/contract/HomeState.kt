package com.emamagic.home.contract

import com.emamagic.common_entity.Genre
import com.emamagic.common_entity.Movie
import com.emamagic.common_entity.Slider
import com.emamagic.core.base.State

data class HomeState(
    val sliders: List<Slider>,
    val genres: List<Genre>,
    val topImdbMovies: List<Movie>,
    val animation: List<Movie>,
    val popularMovies: List<Movie>,
    val series: List<Movie>,
    val closeApp: Boolean,
) : State {
    companion object {
        fun initialize() = HomeState (
            sliders = emptyList(),
            genres = emptyList(),
            topImdbMovies = emptyList(),
            animation = emptyList(),
            popularMovies = emptyList(),
            series = emptyList(),
            closeApp = false
        )
    }
}