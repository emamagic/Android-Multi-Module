package com.emamagic.network.response

import com.emamagic.network.dto.GenreDto
import com.google.gson.annotations.SerializedName

data class GenreListResponse(
    @SerializedName("genres")
    val genres: List<GenreDto>
)

