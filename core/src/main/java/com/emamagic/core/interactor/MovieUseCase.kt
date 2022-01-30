package com.emamagic.core.interactor

import com.emamagic.domain.MovieDetailRepository
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository
) {

    suspend fun getMovieDetail(movieId: String) = movieDetailRepository.getMovieDetails(movieId)

    suspend fun getCasts(movieId: String) = movieDetailRepository.getMovieCasts(movieId)

    suspend fun getSeasons(movieId: String) = movieDetailRepository.getMovieSeasons(movieId)

}