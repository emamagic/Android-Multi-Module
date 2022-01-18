package com.emamagic.network.response

import com.emamagic.network.dto.MovieDetailDto
import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    @SerializedName("detail")
    val movie: List<MovieDetailDto>
)