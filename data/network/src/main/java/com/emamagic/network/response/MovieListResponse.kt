package com.emamagic.network.response

import com.emamagic.network.dto.MovieDto
import com.google.gson.annotations.SerializedName

data class MovieListResponse (
    @SerializedName("movie_streaming")
    val movies: List<MovieDto>
)


