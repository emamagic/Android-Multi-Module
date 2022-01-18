package com.emamagic.core.interactor

import com.emamagic.common_jvm.GenreCategory
import com.emamagic.common_jvm.MovieCategory
import com.emamagic.domain.MovieRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend fun getSliders() =
        movieRepository.getSliders()

    suspend fun getMoviesByMovieCategory(@MovieCategory category: String) =
        movieRepository.getMoviesByMovieCategory(category)

    suspend fun getMoviesByGenreCategory(@GenreCategory category: String) =
        movieRepository.getMoviesByGenreCategory(category)
}