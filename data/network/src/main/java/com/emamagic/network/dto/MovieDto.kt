package com.emamagic.network.dto

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("id")
    val id: Long? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("link_img")
    val imageLink: String,
    @SerializedName("time")
    val time: String? = null,
    @SerializedName("category_name")
    val categoryName: String? = null,
    @SerializedName("rank")
    val rank: String? = null,
    @SerializedName("rate_imdb")
    val imdbRate: String? = null,
    @SerializedName("published")
    val published: String? = null,
    @SerializedName("director")
    val director: String? = null,
    @SerializedName("episode")
    val episode: String? = null,
    @SerializedName("genre_name")
    val genreName: String? = null
)