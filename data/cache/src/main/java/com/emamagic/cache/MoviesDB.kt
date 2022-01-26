package com.emamagic.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.emamagic.cache.dao.GenreDao
import com.emamagic.cache.dao.MovieDao
import com.emamagic.cache.dao.SliderDao
import com.emamagic.cache.entity.GenreEntity
import com.emamagic.cache.entity.MovieEntity
import com.emamagic.cache.entity.SliderEntity

@Database(
    entities = [
        GenreEntity::class,
        MovieEntity::class,
        SliderEntity::class
    ], version = 1, exportSchema = false
)
abstract class MoviesDB : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun sliderDao(): SliderDao
    abstract fun genreDao(): GenreDao

}