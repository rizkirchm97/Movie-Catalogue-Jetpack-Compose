package com.rizkir.data.datasources.local.dao

import com.rizkir.data.model.entity.RemoteKeyEntity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RemoteKeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemoteKeyEntity>)

    @Query("Select * From RemoteKeyEntity Where movie_id = :id")
    suspend fun getRemoteKeyByMovieID(id: Int): RemoteKeyEntity?

    @Query("Delete From RemoteKeyEntity")
    suspend fun clearRemoteKeys()

    @Query("Select created_at From RemoteKeyEntity Order By created_at DESC LIMIT 1")
    suspend fun getCreationTime(): Long?
}