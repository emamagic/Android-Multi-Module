package com.emamagic.domain

import com.emamagic.common_entity.Cast
import com.emamagic.common_entity.Episode
import com.emamagic.common_entity.MovieDetail
import com.emamagic.common_entity.Season
import com.emamagic.common_jvm.ResultWrapper

interface MovieDetailRepository {

    suspend fun getMovieCasts(movieId: String): ResultWrapper<List<Cast>>

    suspend fun getMovieSeasons(movieId: String): ResultWrapper<List<Season>>

    suspend fun getMovieDetails(movieId: String): ResultWrapper<MovieDetail>

}