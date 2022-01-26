package com.emamagic.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.emamagic.cache.BaseDao
import com.emamagic.cache.entity.SliderEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class SliderDao: BaseDao<SliderEntity> {

    @Query("SELECT * FROM table_slider")
    abstract fun getAllSlider(): Flow<List<SliderEntity>>








}