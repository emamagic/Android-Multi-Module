package com.emamagic.network.response

import com.emamagic.network.dto.SliderDto
import com.google.gson.annotations.SerializedName


data class SliderListResponse(
    @SerializedName("slider")
    val sliders: List<SliderDto>
)
