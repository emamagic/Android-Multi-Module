package com.emamagic.repository.repository

import com.emamagic.common_entity.Cast
import com.emamagic.common_entity.Episode
import com.emamagic.common_entity.MovieDetail
import com.emamagic.common_entity.Season
import com.emamagic.common_jvm.ResultWrapper
import com.emamagic.domain.repository.MovieDetailRepository
import com.emamagic.network.service.MovieDetailsService
import com.emamagic.safe.SafeApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDetailRepositoryImpl @Inject constructor(
    private val movieDetailsService: MovieDetailsService
): MovieDetailRepository, SafeApi() {


    override suspend fun getMovieCasts(movieId: String): ResultWrapper<List<Cast>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieSeasons(movieId: String): ResultWrapper<List<Season>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieEpisodes(movieId: String): ResultWrapper<List<Episode>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieDetails(movieId: String): ResultWrapper<List<MovieDetail>> {
        TODO("Not yet implemented")
    }
}