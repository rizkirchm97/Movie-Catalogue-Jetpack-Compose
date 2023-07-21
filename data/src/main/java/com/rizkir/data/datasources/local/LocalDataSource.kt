package com.rizkir.data.datasources.local
import com.rizkir.core.utils.Result
import com.rizkir.data.datasources.BaseDataSource
import com.rizkir.domain.entities.MovieReviewEntity
import com.rizkir.domain.entities.MovieVideoEntity
import com.rizkir.domain.entities.DetailMovieEntity
import kotlinx.coroutines.flow.Flow
import java.io.IOException
import java.lang.Exception

/**
 * created by RIZKI RACHMANUDIN on 20/07/2023
 */
interface LocalDataSource {
    suspend fun getMovieReviews(movieId: Int): Flow<Result<List<MovieReviewEntity>>>
    suspend fun insertMovieReviews(movieReviews: List<MovieReviewEntity>): Result<Boolean>
    suspend fun getMovieVideos(movieId: Int): Flow<Result<List<MovieVideoEntity.Result>>>
    suspend fun insertMovieVideos(movieVideos: List<MovieVideoEntity.Result>): Result<Boolean>
    suspend fun getDetailMovie(movieId: Int): Flow<Result<DetailMovieEntity>>
    suspend fun insertDetailMovie(detailMovie: DetailMovieEntity) : Result<Boolean>
    suspend fun deleteAllMovieReviews(): Result<Boolean>
    suspend fun deleteAllMovieVideos(): Result<Boolean>
    suspend fun deleteAllDetailMovie(): Result<Boolean>

}