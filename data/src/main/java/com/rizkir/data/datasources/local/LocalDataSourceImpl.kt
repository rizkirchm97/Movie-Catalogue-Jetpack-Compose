package com.rizkir.data.datasources.local

import com.rizkir.core.utils.Result
import com.rizkir.data.datasources.DataSourceType
import com.rizkir.data.datasources.local.db.MovieDatabase
import com.rizkir.data.mapper.mapToDataEntity
import com.rizkir.data.mapper.mapToDomainEntity
import com.rizkir.domain.entities.DetailMovieEntity
import com.rizkir.domain.entities.MovieReviewEntity
import com.rizkir.domain.entities.MovieVideoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * created by RIZKI RACHMANUDIN on 20/07/2023
 */
class LocalDataSourceImpl @Inject constructor(
    private val dao: MovieDatabase
) : LocalDataSource {
    override suspend fun getMovieReviews(movieId: Int): Flow<Result<List<MovieReviewEntity>>> =
        flow {
            emit(Result.Loading(true))
            try {
                val result =
                    dao.movieReviewsDao.getMovieReviews(movieId).map { it.mapToDomainEntity() }
                emit(Result.Loading(false))
                emit(Result.Success(result))
            } catch (e: Exception) {
                emit(Result.Loading(false))
                emit(Result.Error(e.localizedMessage.toString(), 0))
            }
        }

    override suspend fun insertMovieReviews(movieReviews: List<MovieReviewEntity>): Result<Boolean> {

        return try {
            dao.movieReviewsDao.upsertAll(movieReviews.map { it.mapToDataEntity() })
            Result.Success(true)
        } catch (e: Exception) {
            Result.Success(false)
            Result.Error(e.localizedMessage.toString(), 0)
        }
    }

    override suspend fun getMovieVideos(movieId: Int): Flow<Result<List<MovieVideoEntity.Result>>> =
        flow {
            emit(Result.Loading(true))
            try {
                val result = dao.movieVideoDao.getMovieVideo(movieId).map { it.mapToDomainEntity() }
                emit(Result.Loading(false))
                emit(Result.Success(result))
            } catch (e: Exception) {
                emit(Result.Loading(false))
                emit(Result.Error(e.localizedMessage.toString(), 0))
            }
        }

    override suspend fun insertMovieVideos(movieVideos: List<MovieVideoEntity.Result>): Result<Boolean> {
        return try {
            dao.movieVideoDao.upsertAll(movieVideos.map { it.mapToDataEntity() })
            Result.Success(true)
        } catch (e: Exception) {
            Result.Success(false)
            Result.Error(e.localizedMessage.toString(), 0)
        }

    }

    override suspend fun getDetailMovie(movieId: Int): Flow<Result<DetailMovieEntity>> = flow {
        emit(Result.Loading(true))
        try {
            val result = dao.movieDetailDao.getMovieDetail(movieId).mapToDomainEntity()
            emit(Result.Loading(false))
            emit(Result.Success(result))
        } catch (e: Exception) {
            emit(Result.Loading(false))
            emit(Result.Error(e.localizedMessage.toString(), 0))
        }
    }

    override suspend fun insertDetailMovie(detailMovie: DetailMovieEntity): Result<Boolean> {
        return try {
            dao.movieDetailDao.upsertAll(detailMovie.mapToDataEntity())
            Result.Success(true)
        } catch (e: Exception) {
            Result.Success(false)
            Result.Error(e.localizedMessage.toString(), 0)
        }
    }

    override suspend fun deleteAllMovieReviews(): Result<Boolean> {
        return try {
            dao.movieReviewsDao.deleteAll()
            Result.Success(true)
        } catch (e: Exception) {
            Result.Success(false)
            Result.Error(e.localizedMessage.toString(), 0)
        }
    }

    override suspend fun deleteAllMovieVideos(): Result<Boolean> {
        return try {
            dao.movieVideoDao.deleteAll()
            Result.Success(true)
        } catch (e: Exception) {
            Result.Success(false)
            Result.Error(e.localizedMessage.toString(), 0)
        }
    }

    override suspend fun deleteAllDetailMovie(): Result<Boolean> {
        return try {
            dao.movieDetailDao.deleteAll()
            Result.Success(true)
        } catch (e: Exception) {
            Result.Success(false)
            Result.Error(e.localizedMessage.toString(), 0)
        }
    }
}
