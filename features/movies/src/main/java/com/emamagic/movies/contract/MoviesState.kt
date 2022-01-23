package com.emamagic.movies.contract

import com.emamagic.common_entity.Movie
import com.emamagic.core.base.State

data class MoviesState(
    val movies: List<Movie>
): State {
    companion object {
        fun initialize() =
            MoviesState(
                movies = emptyList()
            )
    }
}
