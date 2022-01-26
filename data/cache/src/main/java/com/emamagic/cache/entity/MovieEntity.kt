package com.emamagic.cache.entity

import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "table_movie" ,primaryKeys = ["id"])
data class MovieEntity(
    val id: Long? = null,
    val name: String? = null,
    @ColumnInfo(name = "link_img")
    val imageLink: String? = null,
    @ColumnInfo(name = "link_img_movie")
    val imageVideoLink: String? = null,
    @ColumnInfo(name = "link_video")
    val videoLink: String? = null,
    val time: String? = null,
    @ColumnInfo(name = "category_name")
    val categoryName: String? = null,
    val rank: String? = null,
    @ColumnInfo(name = "rate_imdb")
    val imdbRate: String? = null,
    val published: String? = null,
    val director: String? = null,
    @ColumnInfo(name = "address_img")
    val imageAddress: String? = null,
    @ColumnInfo(name = "episode")
    val episode: String? = null,
    val description: String? = null,
    @ColumnInfo(name = "genre_name")
    val genreName: String? = null,
    val updatedAt: Long = System.currentTimeMillis(),
    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean? = false
): Parcelable
