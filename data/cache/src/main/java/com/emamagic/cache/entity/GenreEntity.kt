package com.emamagic.cache.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "table_genre" ,primaryKeys = ["id"])
data class GenreEntity(
    val id: Long,
    val name: String,
    @ColumnInfo(name = "link_img")
    val imageLing: String,
    @ColumnInfo(name = "address_img")
    val imageAddress: String? = null,
    val updatedAt: Long = System.currentTimeMillis()
)