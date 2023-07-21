package com.rizkir.data.datasources.remote

import com.rizkir.core.utils.Result
import com.rizkir.data.datasources.BaseDataSource
import com.rizkir.domain.entities.DetailMovieEntity
import kotlinx.coroutines.flow.Flow
import com.rizkir.domain.entities.MovieVideoEntity as DomainMovieVideoEntity
import com.rizkir.domain.entities.MovieReviewEntity as DomainMovieReviewsEntity

/**
 * created by RIZKI RACHMANUDIN on 20/07/2023
 */
interface RemoteDataSource {
    suspend fun fetchDetailMovie(movieId: Int?): Flow<Result<DetailMovieEntity>>
    suspend fun fetchMovieVideos(MovieId: Int?): Flow<Result<List<DomainMovieVideoEntity.Result>>>
    suspend fun fetchMovieReviews(movieId: Int?): Flow<Result<List<DomainMovieReviewsEntity>>>
}