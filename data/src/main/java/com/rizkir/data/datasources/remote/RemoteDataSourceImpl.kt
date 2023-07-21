package com.rizkir.data.datasources.remote

import android.util.Log
import androidx.room.withTransaction
import com.rizkir.core.utils.Result
import com.rizkir.data.datasources.local.LocalDataSource
import com.rizkir.data.datasources.local.db.MovieDatabase
import com.rizkir.data.mapper.mapToDomainEntity
import com.rizkir.data.mapper.mapToEntity
import com.rizkir.domain.entities.MovieVideoEntity
import com.rizkir.domain.entities.DetailMovieEntity
import com.rizkir.domain.entities.MovieReviewEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * created by RIZKI RACHMANUDIN on 20/07/2023
 */
@Singleton
class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val db: MovieDatabase,
    private val localDataSource: LocalDataSource
) : RemoteDataSource {
    override suspend fun fetchDetailMovie(movieId: Int?): Flow<Result<DetailMovieEntity>> =
        flow {
            emit(Result.Loading(true))
            try {
                val response = movieId?.let { apiService.getDetailMovie(it) }
                emit(Result.Loading(false))
                if (response?.isSuccessful == true) {
                    val mappedResponse = response.body()?.mapToEntity()
                    Log.e("RemoteDataSourceImpl", "fetchDetailMovie: $mappedResponse")

                    db.withTransaction {
                        localDataSource.insertDetailMovie(mappedResponse as DetailMovieEntity)
                    }
                    emit(Result.Success(mappedResponse as DetailMovieEntity))

                } else {
                    emit(
                        Result.Error(
                            message = response?.message().toString(),
                            code = response?.code()
                        )
                    )
                }
            } catch (e: IOException) {
                emit(Result.Error(message = e.localizedMessage.toString(), code = 0))

            } catch (e: HttpException) {
                emit(Result.Error(message = e.localizedMessage.toString(), code = e.code()))
            }
        }.flowOn(Dispatchers.IO)

    override suspend fun fetchMovieVideos(MovieId: Int?): Flow<Result<List<MovieVideoEntity.Result>>> =
        flow {
            emit(Result.Loading(true))
            try {
                val response = apiService.getDetailMovieVideos(MovieId)
                emit(Result.Loading(false))
                if (response.isSuccessful) {
                    val movieId = response.body()?.id
                    val mappedResult = response.body()?.results?.map { movieVideos ->
                        movieId?.let { movieId ->
                            movieVideos.mapToDomainEntity(
                                movieId
                            )
                        }

                    }?.toList()
                    Log.e("RemoteDataSourceImpl", "fetchMovieVideos: $mappedResult")

                    db.withTransaction {
                        localDataSource.insertMovieVideos(mappedResult as List<MovieVideoEntity.Result>)
                    }

                    emit(Result.Success(mappedResult as List<MovieVideoEntity.Result>))
                } else {
                    emit(
                        Result.Error(
                            message = response.message(),
                            code = response.code()
                        )
                    )
                }
            } catch (e: IOException) {
                emit(Result.Error(message = e.localizedMessage.toString(), code = 0))

            } catch (e: HttpException) {
                emit(Result.Error(message = e.localizedMessage.toString(), code = e.code()))
            }
        }.flowOn(Dispatchers.IO)

    override suspend fun fetchMovieReviews(movieId: Int?): Flow<Result<List<MovieReviewEntity>>> =
        flow {
            emit(Result.Loading(true))
            try {
                val response = apiService.getMovieReview(movieId)
                emit(Result.Loading(false))
                if (response.isSuccessful) {
                    val movieId = response.body()?.id
                    val mappedResult = response.body()?.results?.map { movieReview ->
                        movieId?.let { movieId ->
                            movieReview.mapToDomainEntity(
                                movieId,
                                movieReview.author_details.avatar_path
                            )
                        }

                    }?.toList()?.take(5)

                    Log.e("RemoteDataSourceImpl", "fetchMovieReviews: $mappedResult")

                    db.withTransaction {
                        localDataSource.insertMovieReviews(mappedResult as List<MovieReviewEntity>)
                    }


                    emit(Result.Success(mappedResult as List<MovieReviewEntity>))
                } else {
                    emit(
                        Result.Error(
                            message = response.message(),
                            code = response.code()
                        )
                    )
                }
            } catch (e: IOException) {
                emit(Result.Error(message = e.localizedMessage.toString(), code = 0))

            } catch (e: HttpException) {
                emit(Result.Error(message = e.localizedMessage.toString(), code = e.code()))
            }
        }.flowOn(Dispatchers.IO)
}