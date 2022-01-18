package com.emamagic.network.service

import com.emamagic.network.response.MovieListResponse
import com.emamagic.network.response.SliderListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("getSlider.php")
    suspend fun getSliders(): SliderListResponse

    @GET("getInformationHome.php")
    suspend fun getMoviesByMovieCategory(
        @Query("category_name") category: String
    ): MovieListResponse

    @GET("getAllInforamtionHome.php")
    suspend fun getAllMovie(
        @Query("category_name") category: String
    ): MovieListResponse

    @GET("get_show_genre.php")
    suspend fun getMoviesByGenreCategory(
        @Query("genre_name") genreName: String
    ): MovieListResponse

    @GET("getSearch.php")
    suspend fun searchMovies(
        @Query("category_name") category: String,
        @Query("name") query: String
    ): Response<MovieListResponse>

}