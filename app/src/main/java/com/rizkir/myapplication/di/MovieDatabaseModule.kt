package com.rizkir.myapplication.di

import android.content.Context
import androidx.room.Room
import com.rizkir.data.datasources.local.db.MovieDatabase
import com.rizkir.data.datasources.local.dao.MovieDiscoverDao
import com.rizkir.data.datasources.local.dao.RemoteKeyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieDatabaseModule {

    @Provides
    @Singleton
    fun provideMovieDatabase(@ApplicationContext context: Context): MovieDatabase {
        return Room.databaseBuilder(
            context = context,
            MovieDatabase::class.java,
            "movies.db",
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideMoviesDao(moviesDatabase: MovieDatabase): MovieDiscoverDao = moviesDatabase.movieDao

    @Singleton
    @Provides
    fun provideRemoteKeysDao(moviesDatabase: MovieDatabase): RemoteKeyDao =
        moviesDatabase.remoteKeyDao
}