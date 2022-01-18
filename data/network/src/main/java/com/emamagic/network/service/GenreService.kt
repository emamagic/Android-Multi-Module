package com.emamagic.network.service

import com.emamagic.network.response.GenreListResponse
import com.emamagic.network.response.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GenreService {

    @GET("GetAllGenre.php")
    suspend fun getAllGenre(): GenreListResponse

}