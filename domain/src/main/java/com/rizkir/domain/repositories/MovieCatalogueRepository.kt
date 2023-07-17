package com.rizkir.domain.repositories

import com.rizkir.domain.entities.MovieEntity
import kotlinx.coroutines.flow.Flow
import com.rizkir.core.utils.Result
import com.rizkir.domain.entities.DetailMovieEntity
import com.rizkir.domain.entities.MovieImageEntity
import com.rizkir.domain.entities.MovieReviewEntity
import com.rizkir.domain.entities.MovieVideoEntity
import com.rizkir.domain.usecases.DetailMovieUseCase
import com.rizkir.domain.usecases.MovieImageUseCase
import com.rizkir.domain.usecases.MovieReviewsUseCase
import com.rizkir.domain.usecases.MovieVideosUseCase

interface MovieCatalogueRepository {
    suspend fun fetchDiscoverMovie(): Flow<Result<List<MovieEntity>>>

    suspend fun fetchDetailMovie(params: DetailMovieUseCase.Params?): Flow<Result<DetailMovieEntity>>

    suspend fun fetchMovieImages(params: MovieImageUseCase.Params?): Flow<Result<List<MovieImageEntity>>>

    suspend fun fetchMovieVideos(params: MovieVideosUseCase.Params?): Flow<Result<List<MovieVideoEntity>>>

    suspend fun fetchMovieReviews(params: MovieReviewsUseCase.Params?): Flow<Result<List<MovieReviewEntity>>>
}