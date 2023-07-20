package com.rizkir.data.datasources.local

import com.rizkir.data.model.entity.RemoteKeyEntity
import androidx.room.Database
import androidx.room.RoomDatabase
import com.rizkir.data.model.entity.DiscoverMovieCacheEntity

@Database(
    entities = [DiscoverMovieCacheEntity::class, RemoteKeyEntity::class],
    version = 3
)
abstract class MovieDatabase: RoomDatabase() {
    abstract val movieDao: MovieDiscoverDao
    abstract val remoteKeyDao: RemoteKeyDao
}