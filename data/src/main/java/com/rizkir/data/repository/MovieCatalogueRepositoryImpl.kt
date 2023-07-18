package com.rizkir.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.rizkir.data.datasources.remote.ApiService
import com.rizkir.domain.entities.DetailMovieEntity
import com.rizkir.domain.entities.MovieEntity
import com.rizkir.domain.entities.MovieImageEntity
import com.rizkir.domain.entities.MovieReviewEntity
import com.rizkir.domain.entities.MovieVideoEntity
import com.rizkir.domain.repositories.MovieCatalogueRepository
import com.rizkir.domain.usecases.DetailMovieUseCase
import com.rizkir.domain.usecases.MovieImageUseCase
import com.rizkir.domain.usecases.MovieReviewsUseCase
import com.rizkir.domain.usecases.MovieVideosUseCase
import kotlinx.coroutines.flow.Flow
import com.rizkir.core.utils.Result
import com.rizkir.core.utils.code
import com.rizkir.core.utils.message
import com.rizkir.data.datasources.AppDataSource
import com.rizkir.data.mapper.mapToEntity
import com.rizkir.domain.usecases.DiscoverMovieUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */

@Singleton
class MovieCatalogueRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MovieCatalogueRepository {
    override suspend fun fetchDiscoverMovie(params: Int) = Pager(
        PagingConfig(20)
    ) {
        AppDataSource(
            apiService = apiService
        )
    }.flow.flowOn(Dispatchers.IO)
//    withContext(Dispatchers.IO) {
//            flow <Result<List<MovieEntity>>> {
//                emit(Result.Loading(true))
//                val response = apiService.fetchDiscoverMovie(params)
//                emit(Result.Loading(false))
//
//                when {
//                    response.errorBody() != null -> {
//                        emit(
//                            Result.Error(
//                                message = response.message(),
//                                code = response.code()
//                            )
//                        )
//                    }
//
//
//                    response.isSuccessful -> {
//                        response.body()?.results?.map { it.mapToEntity() }.let {
//                            emit(Result.Success(it) as Result<List<MovieEntity>>)
//                        }
//
//                    }
//                }
//            }.flowOn(Dispatchers.IO).catch { error ->
//                Timber.e(message = error.localizedMessage)
//                emit(Result.Loading(false))
//                delay(5)
//                emit(Result.Error(message = message(error), code = code(error)))
//            }.flowOn(Dispatchers.IO)
//        }


    override suspend fun fetchDetailMovie(params: DetailMovieUseCase.Params?): Flow<Result<DetailMovieEntity>> =
        withContext(Dispatchers.IO) {
            flow {
                emit(Result.Loading(true))
                if (params?.movieId == null) {
                    Timber.e("params is null")
                    emit(Result.Loading(false))
                    delay(5)
                    emit(Result.Error(message = "Params is null", code = 999))
                }
                val response = params?.movieId?.let { apiService.getDetailMovie(it) }
                emit(Result.Loading(false))
                when {
                    response?.errorBody() != null -> {
                        emit(
                            Result.Error(
                                message = response.message(),
                                code = response.code()
                            )
                        )
                    }

                    response?.isSuccessful == true -> {
                        emit(Result.Success(response.body()?.mapToEntity()) as Result<DetailMovieEntity>)
                    }
                }

            }.catch { error ->
                Timber.e(message = error.localizedMessage)
                emit(Result.Loading(false))
                delay(5)
                emit(Result.Error(message = message(error), code = code(error)))
            }
        }


    override suspend fun fetchMovieImages(params: MovieImageUseCase.Params?): Flow<Result<MovieImageEntity>> =
        withContext(Dispatchers.IO) {
            flow {
                emit(Result.Loading(true))
                if (params?.movieId == null) {
                    Timber.e("params is null")
                    emit(Result.Loading(false))
                    delay(5)
                    emit(Result.Error(message = "Params is null", code = 999))
                }

                val response = params?.movieId?.let { apiService.getDetailMovieImages(it) }

                emit(Result.Loading(false))
                when {
                    response?.errorBody() != null -> {
                        emit(
                            Result.Error(
                                message = response.message(),
                                code = response.code()
                            )
                        )
                    }

                    response?.isSuccessful == true -> {
                        emit(Result.Success(response.body()?.mapToEntity()) as Result<MovieImageEntity>)
                    }
                }

            }.catch { error ->
                Timber.e(message = error.localizedMessage)
                emit(Result.Loading(false))
                delay(5)
                emit(Result.Error(message = message(error), code = code(error)))
            }
        }

    override suspend fun fetchMovieVideos(params: MovieVideosUseCase.Params?): Flow<Result<MovieVideoEntity>> =
        withContext(Dispatchers.IO) {
            flow {
                emit(Result.Loading(true))
                if (params?.movieId == null) {
                    Timber.e("params is null")
                    emit(Result.Loading(false))
                    delay(5)
                    emit(Result.Error(message = "Params is null", code = 999))
                }

                val response = params?.movieId?.let { apiService.getDetailMovieVideos(it) }

                emit(Result.Loading(false))
                when {
                    response?.errorBody() != null -> {
                        emit(
                            Result.Error(
                                message = response.message(),
                                code = response.code()
                            )
                        )
                    }

                    response?.isSuccessful == true -> {
                        emit(Result.Success(response.body()?.mapToEntity()) as Result<MovieVideoEntity>)
                    }
                }

            }.catch { error ->
                Timber.e(message = error.localizedMessage)
                emit(Result.Loading(false))
                delay(5)
                emit(Result.Error(message = message(error), code = code(error)))
            }
        }


    override suspend fun fetchMovieReviews(params: MovieReviewsUseCase.Params?): Flow<Result<MovieReviewEntity>> =
        withContext(Dispatchers.IO) {
            flow {
                emit(Result.Loading(true))
                if (params?.movieId == null) {
                    Timber.e("params is null")
                    emit(Result.Loading(false))
                    delay(5)
                    emit(Result.Error(message = "Params is null", code = 999))
                }

                val response = params?.movieId?.let { apiService.getMovieReview(it) }

                emit(Result.Loading(false))
                when {
                    response?.errorBody() != null -> {
                        emit(
                            Result.Error(
                                message = response.message(),
                                code = response.code()
                            )
                        )
                    }

                    response?.isSuccessful == true -> {
                        emit(Result.Success(response.body()?.mapToEntity()) as Result<MovieReviewEntity>)
                    }
                }

            }.catch { error ->
                Timber.e(message = error.localizedMessage)
                emit(Result.Loading(false))
                delay(5)
                emit(Result.Error(message = message(error), code = code(error)))
            }
        }
}