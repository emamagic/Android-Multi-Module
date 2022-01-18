package com.emamagic.network.dto

import com.google.gson.annotations.SerializedName

data class EpisodeDto(
    @SerializedName("id")
    val id: Long? = null,
    @SerializedName("id_season")
    val seasonId: Long? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("link_img")
    val imageLink: String? = null,
    @SerializedName("detail")
    val detail: String? = null,
    @SerializedName("time")
    val time: String? = null,
    @SerializedName("link_play_episode")
    val videoLink: String? = null
)
