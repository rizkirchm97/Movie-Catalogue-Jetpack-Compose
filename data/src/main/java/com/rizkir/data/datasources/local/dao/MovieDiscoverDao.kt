package com.rizkir.data.datasources.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.rizkir.data.model.entity.DiscoverMovieCacheEntity

@Dao
interface MovieDiscoverDao {

    @Upsert
    suspend fun upsertAll(movies: List<DiscoverMovieCacheEntity>)

    @Query("SELECT * FROM DiscoverMovieCacheEntity  Order By page")
    fun pagingSource(): PagingSource<Int, DiscoverMovieCacheEntity>

    @Query("DELETE FROM DiscoverMovieCacheEntity")
    suspend fun deleteAll()

}