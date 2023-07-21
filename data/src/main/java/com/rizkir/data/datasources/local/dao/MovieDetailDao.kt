package com.rizkir.data.datasources.local.dao


import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.rizkir.data.model.entity.MovieDetailEntity

/**
 * created by RIZKI RACHMANUDIN on 20/07/2023
 */

@Dao
interface MovieDetailDao {

    @Upsert
    suspend fun upsertAll(movies: MovieDetailEntity)

    @Query("DELETE FROM MovieDetail")
    suspend fun deleteAll()

    @Query("SELECT * FROM MovieDetail WHERE id = :movieId")
    suspend fun getMovieDetail(movieId: Int): MovieDetailEntity
}