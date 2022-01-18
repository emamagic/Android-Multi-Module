package com.emamagic.network.response

import com.emamagic.network.dto.CastDto
import com.google.gson.annotations.SerializedName

data class CastResponse(
    @SerializedName("casts")
    val casts: List<CastDto>
)