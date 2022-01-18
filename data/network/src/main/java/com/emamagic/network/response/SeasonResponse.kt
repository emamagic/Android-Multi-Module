package com.emamagic.network.response

import com.emamagic.network.dto.SeasonDto
import com.google.gson.annotations.SerializedName

data class SeasonResponse(
    @SerializedName("seasons")
    val seasons: List<SeasonDto>
)