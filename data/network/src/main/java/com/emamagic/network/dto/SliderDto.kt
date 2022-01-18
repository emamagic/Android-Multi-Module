package com.emamagic.network.dto

import com.google.gson.annotations.SerializedName


data class SliderDto(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("link_img")
    val imageLink: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("published")
    val published: String
)