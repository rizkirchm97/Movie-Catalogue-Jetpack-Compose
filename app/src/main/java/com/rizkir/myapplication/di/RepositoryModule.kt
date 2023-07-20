package com.rizkir.myapplication.di

import com.rizkir.data.repository.MovieCatalogueRepositoryImpl
import com.rizkir.domain.repositories.MovieCatalogueRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindMovieRepository(movieCatalogueRepositoryImpl: MovieCatalogueRepositoryImpl): MovieCatalogueRepository
}