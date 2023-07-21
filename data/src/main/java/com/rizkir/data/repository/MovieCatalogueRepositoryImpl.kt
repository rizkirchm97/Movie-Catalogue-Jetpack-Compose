package com.rizkir.data.repository

import androidx.lifecycle.LiveData
import com.rizkir.domain.entities.DetailMovieEntity
import com.rizkir.domain.entities.MovieReviewEntity
import com.rizkir.domain.entities.MovieVideoEntity
import com.rizkir.domain.repositories.MovieCatalogueRepository
import com.rizkir.domain.usecases.DetailMovieUseCase
import com.rizkir.domain.usecases.MovieReviewsUseCase
import com.rizkir.domain.usecases.MovieVideosUseCase
import kotlinx.coroutines.flow.Flow
import com.rizkir.core.utils.Result
import com.rizkir.data.datasources.local.LocalDataSource
import com.rizkir.data.datasources.remote.RemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */

@Singleton
class MovieCatalogueRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
    ) : MovieCatalogueRepository {


    override suspend fun fetchDetailMovie(params: DetailMovieUseCase.Params?): Flow<Result<DetailMovieEntity>> {

        return remoteDataSource.fetchDetailMovie(params?.movieId!!)

    }


    override suspend fun fetchMovieVideos(params: MovieVideosUseCase.Params?): Flow<Result<List<MovieVideoEntity.Result>>> {

        return remoteDataSource.fetchMovieVideos(params?.movieId!!)

    }


    override suspend fun fetchMovieReviews(params: MovieReviewsUseCase.Params?): Flow<Result<List<MovieReviewEntity>>> {

        return remoteDataSource.fetchMovieReviews(params?.movieId!!)

    }
}