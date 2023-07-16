package com.rizkir.debugmain

import com.rizkir.di.utils.ApiBaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class BaseUrlModule{
    @Provides
    @ApiBaseUrl
    fun provideBaseUrl() : String = "https://api.themoviedb.org/3"
}