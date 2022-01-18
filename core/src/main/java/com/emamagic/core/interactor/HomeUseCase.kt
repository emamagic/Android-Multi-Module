package com.emamagic.core.interactor

import com.emamagic.common_jvm.MovieCategory
import com.emamagic.domain.repository.MovieRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend fun getSliders() =
        movieRepository.getSliders()

    suspend fun getMoviesByMovieCategory(@MovieCategory category: String) =
        movieRepository.getMoviesByMovieCategory(category)

}