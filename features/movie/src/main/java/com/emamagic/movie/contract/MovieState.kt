package com.emamagic.movie.contract

import com.emamagic.common_entity.Cast
import com.emamagic.common_entity.Movie
import com.emamagic.common_entity.Season
import com.emamagic.core.base.State

data class MovieState(
    val movie: Movie? = null,
    val casts: List<Cast>,
    val season: List<Season>
) : State {
    companion object {
        fun initialize() =
            MovieState(
                movie = null,
                casts = emptyList(),
                season = emptyList()
            )
    }
}