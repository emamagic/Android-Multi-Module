package com.emamagic.network.response

import com.emamagic.network.dto.EpisodeDto
import com.google.gson.annotations.SerializedName

data class EpisodeResponse(
    @SerializedName("episodes")
    val episodes: List<EpisodeDto>
)