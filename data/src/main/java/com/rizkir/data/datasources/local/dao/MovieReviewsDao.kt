package com.rizkir.data.datasources.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.rizkir.data.model.entity.MovieReviewsEntity

/**
 * created by RIZKI RACHMANUDIN on 20/07/2023
 */

@Dao
interface MovieReviewsDao {
    @Upsert
    suspend fun upsertAll(movies: List<MovieReviewsEntity>)

    @Query("DELETE FROM MovieReviews")
    suspend fun deleteAll()

    @Query("SELECT * FROM MovieReviews WHERE id = :movieId")
    suspend fun getMovieReviews(movieId: Int): List<MovieReviewsEntity>

}