package com.emamagic.movies.contract

import com.emamagic.common_jvm.MovieCategory
import com.emamagic.core.base.Event

sealed class MoviesEvent: Event {

    data class GetMoviesByCategory(@MovieCategory val category: String): MoviesEvent()

}