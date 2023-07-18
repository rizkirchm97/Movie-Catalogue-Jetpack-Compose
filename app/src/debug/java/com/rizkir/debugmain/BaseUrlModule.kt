package com.rizkir.debugmain

import com.rizkir.di.utils.ApiBaseUrl
import com.rizkir.di.utils.ImageBaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class BaseUrlModule{
    @Provides
    @ApiBaseUrl
    fun provideBaseUrl() : String = "https://api.themoviedb.org/3/"

    @Provides
    @ImageBaseUrl
    fun provideImageBaseUrl() : String = "https://image.tmdb.org/t/p/w500/"
}