package com.rizkir.data.datasources.local.db

import com.rizkir.data.model.entity.RemoteKeyEntity
import androidx.room.Database
import androidx.room.RoomDatabase
import com.rizkir.data.datasources.local.dao.MovieDetailDao
import com.rizkir.data.datasources.local.dao.MovieDiscoverDao
import com.rizkir.data.datasources.local.dao.MovieReviewsDao
import com.rizkir.data.datasources.local.dao.MovieVideoDao
import com.rizkir.data.datasources.local.dao.RemoteKeyDao
import com.rizkir.data.model.entity.DiscoverMovieCacheEntity
import com.rizkir.data.model.entity.MovieDetailEntity
import com.rizkir.data.model.entity.MovieReviewsEntity
import com.rizkir.data.model.entity.MovieVideoEntity

@Database(
    entities = [
        DiscoverMovieCacheEntity::class,
        RemoteKeyEntity::class,
        MovieDetailEntity::class,
        MovieReviewsEntity::class,
        MovieVideoEntity::class
    ],
    version = 4
)
abstract class MovieDatabase : RoomDatabase() {
    abstract val movieDao: MovieDiscoverDao
    abstract val remoteKeyDao: RemoteKeyDao
    abstract val movieDetailDao: MovieDetailDao
    abstract val movieReviewsDao: MovieReviewsDao
    abstract val movieVideoDao: MovieVideoDao
}