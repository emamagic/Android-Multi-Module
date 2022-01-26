package com.emamagic.cache.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "table_slider" ,primaryKeys = ["id"])
data class SliderEntity(
    val id: Long,
    val name: String,
    val time: String,
    val published: String,
    @ColumnInfo(name = "link_img")
    val imageLink: String,
    @ColumnInfo(name = "address_img")
    val imageAddress: String? = null,
    val updatedAt: Long = System.currentTimeMillis()
)