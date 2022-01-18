package com.emamagic.network.dto

import com.google.gson.annotations.SerializedName

data class MovieDetailDto(
    @SerializedName("id")
    val id: Long,
    @SerializedName("description")
    val description: String,
    @SerializedName("link_img")
    val imageVideoLink: String,
    @SerializedName("link_video")
    val videoLink: String,
    @SerializedName("id_item")
    val itemId: Long
)