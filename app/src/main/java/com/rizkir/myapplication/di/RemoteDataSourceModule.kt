package com.rizkir.myapplication.di

import com.rizkir.data.datasources.remote.RemoteDataSource
import com.rizkir.data.datasources.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * created by RIZKI RACHMANUDIN on 20/07/2023
 */

@Module
@InstallIn(SingletonComponent::class)
interface RemoteDataSourceModule {

    @Binds
    fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}