package com.emamagic.network.dto

import com.google.gson.annotations.SerializedName

data class CastDto(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("link_img")
    val imageLink: String,
    @SerializedName("id_item")
    val itemId: Long
)