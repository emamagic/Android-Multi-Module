package com.emamagic.network.dto

import com.google.gson.annotations.SerializedName

data class SeasonDto(
    @SerializedName("id")
    val id: Long?,
    @SerializedName("id_item")
    val itemId: Long?,
    @SerializedName("number_season")
    val season: Int?,
    @SerializedName("count_episodes")
    val episode: Int?,
    @SerializedName("link_img")
    val imageLink: String?
)