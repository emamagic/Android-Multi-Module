package com.emamagic.network.service

import com.emamagic.network.response.GenreListResponse
import com.emamagic.network.response.MovieListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GenreService {

    @GET("getGenre.php")
    suspend fun getAllGenre(): Response<GenreListResponse>

}