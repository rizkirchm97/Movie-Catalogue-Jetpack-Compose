package com.rizkir.myapplication.di

import com.rizkir.data.datasources.local.LocalDataSource
import com.rizkir.data.datasources.local.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * created by RIZKI RACHMANUDIN on 20/07/2023
 */

@Module
@InstallIn(SingletonComponent::class)
interface LocalDataSourceModule {

    @Binds
    fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource
}