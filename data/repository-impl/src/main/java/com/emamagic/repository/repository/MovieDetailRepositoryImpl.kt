package com.emamagic.repository.repository

import com.emamagic.common_entity.Cast
import com.emamagic.common_entity.MovieDetail
import com.emamagic.common_entity.Season
import com.emamagic.common_jvm.ResultWrapper
import com.emamagic.domain.MovieDetailRepository
import com.emamagic.network.dto.CastDto
import com.emamagic.network.dto.MovieDetailDto
import com.emamagic.network.dto.SeasonDto
import com.emamagic.network.service.MovieDetailsService
import com.emamagic.repository.mapper.DataClassMapper
import com.emamagic.safe.SafeApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDetailRepositoryImpl @Inject constructor(
    private val movieDetailsService: MovieDetailsService
) : MovieDetailRepository, SafeApi() {


    override suspend fun getMovieCasts(movieId: String): ResultWrapper<List<Cast>> = getSafe(
        remoteFetch = { movieDetailsService.getCasts(movieId) },
        mapping = { response -> response.casts.map { DataClassMapper<CastDto, Cast>()(it) } }
    )

    override suspend fun getMovieSeasons(movieId: String): ResultWrapper<List<Season>> = getSafe(
        remoteFetch = { movieDetailsService.getSeasons(movieId) },
        mapping = { response -> response.seasons.map { DataClassMapper<SeasonDto, Season>()(it) } }
    )

    override suspend fun getMovieDetails(movieId: String): ResultWrapper<MovieDetail> = getSafe(
        remoteFetch = { movieDetailsService.getDetailMovie(movieId) },
        mapping = { response -> DataClassMapper<MovieDetailDto, MovieDetail>()(response.movie) }
    )
}