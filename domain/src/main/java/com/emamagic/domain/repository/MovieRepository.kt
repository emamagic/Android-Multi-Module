package com.emamagic.domain.repository

import com.emamagic.common_entity.Movie
import com.emamagic.common_entity.Slider
import com.emamagic.common_jvm.GenreCategory
import com.emamagic.common_jvm.MovieCategory
import com.emamagic.common_jvm.ResultWrapper

interface MovieRepository {

    suspend fun getSliders(): ResultWrapper<List<Slider>>

    suspend fun getMoviesByMovieCategory(@MovieCategory category: String): ResultWrapper<List<Movie>>

    suspend fun getAllMovie(): ResultWrapper<List<Movie>>

    suspend fun getMoviesByGenreCategory(@GenreCategory category: String): ResultWrapper<List<Movie>>

    suspend fun searchMovies(@MovieCategory category: String, query: String): ResultWrapper<List<Movie>>
}