package com.rizkir.data.datasources.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.rizkir.data.model.entity.MovieVideoEntity

/**
 * created by RIZKI RACHMANUDIN on 20/07/2023
 */
@Dao
interface MovieVideoDao {

    @Upsert
    suspend fun upsertAll(movies: List<MovieVideoEntity>)

    @Query("DELETE FROM MovieVideo")
    suspend fun deleteAll()

    @Query(
        """
            SELECT * FROM MovieVideo 
            WHERE id = :movieId
            AND `key` IS NOT NULL OR `key` != ''
            AND LOWER(site) LIKE LOWER('YOUTUBE') LIMIT 1
        """
    )
    suspend fun getMovieVideo(movieId: Int): List<MovieVideoEntity>
}