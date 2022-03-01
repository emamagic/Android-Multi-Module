package com.emamagic.core.interactor

import com.emamagic.common_jvm.MovieCategory
import com.emamagic.domain.MovieRepository
import javax.inject.Inject

class MoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend fun getMoviesByMovieCategory(@MovieCategory category: String) =
        movieRepository.getMoviesByMovieCategory(category)

}