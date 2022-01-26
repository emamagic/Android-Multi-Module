package com.emamagic.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.emamagic.cache.BaseDao
import com.emamagic.cache.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class MovieDao: BaseDao<MovieEntity> {

    /** THIS QUERY IS FOR TESTING */
    @Query("SELECT * FROM TABLE_MOVIE")
    abstract fun getMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM table_movie WHERE category_name = :category  LIMIT 6")
    abstract fun getMoviesByCategoryLimit6(category: String): Flow<List<MovieEntity>>

    @Query("SELECT * FROM table_movie WHERE id = :id")
    abstract suspend fun getMovieById(id: Long): MovieEntity

    @Query("UPDATE table_movie SET description = :description ,link_img_movie = :imageVideoLink ,link_video = :videoLink  WHERE id = :id")
    abstract suspend fun updateMovieDetailById(id: Long, description: String?, imageVideoLink: String?, videoLink: String?)

// UPDATE table_favorite SET isFavorite = CASE WHEN isFavorite = 0 THEN 1 ELSE 0 END WHERE id = :id
// INSERT INTO table_favorite(movieId) SELECT :id WHERE NOT EXISTS(SELECT 1 FROM table_favorite WHERE movieId = :id)

}