package com.rizkir.myapplication.di

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.rizkir.data.datasources.local.db.MovieDatabase
import com.rizkir.data.datasources.remote.ApiService
import com.rizkir.data.datasources.remote.MovieRemoteMediator
import com.rizkir.data.model.entity.DiscoverMovieCacheEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object PaginationModule {

    @Provides
    @Singleton
    fun provideMoviePager(movieDb: MovieDatabase, apiService: ApiService): Pager<Int, DiscoverMovieCacheEntity> {
        return Pager(
            config = PagingConfig(pageSize = 20, initialLoadSize = 20, prefetchDistance = 10),
            remoteMediator = MovieRemoteMediator(
                movieDb = movieDb,
                apiService = apiService
            ),
            pagingSourceFactory = {
                movieDb.movieDao.pagingSource()
            }
        )
    }
}