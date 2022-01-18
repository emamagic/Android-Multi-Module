package com.emamagic.repository.repository

import com.emamagic.common_entity.Movie
import com.emamagic.common_entity.Slider
import com.emamagic.common_jvm.ResultWrapper
import com.emamagic.domain.MovieRepository
import com.emamagic.network.dto.MovieDto
import com.emamagic.network.dto.SliderDto
import com.emamagic.network.service.MovieService
import com.emamagic.repository.mapper.DataClassMapper
import com.emamagic.safe.SafeApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService
) : MovieRepository, SafeApi() {

    override suspend fun getSliders(): ResultWrapper<List<Slider>> = safe(
        networkCall = { movieService.getSliders() },
        mapping = { response -> response.sliders.map { DataClassMapper<SliderDto,Slider>()(it) } }
    )

    override suspend fun getMoviesByMovieCategory(category: String): ResultWrapper<List<Movie>> = safe(
        networkCall = { movieService.getMoviesByMovieCategory(category) },
        mapping = { response -> response.movies.map { DataClassMapper<MovieDto,Movie>()(it) } }
    )

    override suspend fun getMoviesByGenreCategory(category: String): ResultWrapper<List<Movie>> {
        TODO("Not yet implemented")
    }

    override suspend fun searchMovies(category: String, query: String): ResultWrapper<List<Movie>> {
        TODO("Not yet implemented")
    }
}