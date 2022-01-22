package com.emamagic.core.interactor

import com.emamagic.common_jvm.MovieCategory
import com.emamagic.domain.GenreRepository
import com.emamagic.domain.MovieRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val genreRepository: GenreRepository
) {

    suspend fun getSliders() =
        movieRepository.getSliders()

    suspend fun getMoviesByMovieCategory(@MovieCategory category: String) =
        movieRepository.getMoviesByMovieCategory(category)

    suspend fun getGenre() =
        genreRepository.getAllGenre()
}