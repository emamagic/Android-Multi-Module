package com.emamagic.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.emamagic.cache.BaseDao
import com.emamagic.cache.entity.GenreEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class GenreDao: BaseDao<GenreEntity> {

    @Query("SELECT * FROM table_genre LIMIT 6")
    abstract fun getGenre(): Flow<List<GenreEntity>>

    @Query("SELECT * FROM table_genre")
    abstract fun getAllGenre(): Flow<List<GenreEntity>>
}