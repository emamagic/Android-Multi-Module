package com.emamagic.network.service

import com.emamagic.network.response.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDetailsService {

    @GET("getCast.php")
    suspend fun getCasts(
        @Query("id_item") itemId: String
    ): CastResponse

    @GET("getSeasons.php")
    suspend fun getSeasons(
        @Query("id_item") itemId: String
    ): SeasonResponse

    @GET("getEpisodes.php")
    suspend fun getEpisodes(
        @Query("id_season") seasonId: String
    ): EpisodeResponse

    @GET("show_detail.php")
    suspend fun getDetailMovie(
        @Query("id_item") itemId: String
    ): Response<MovieDetailResponse>


}