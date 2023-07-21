package com.rizkir.domain.repositories

import kotlinx.coroutines.flow.Flow
import com.rizkir.core.utils.Result
import com.rizkir.domain.entities.DetailMovieEntity
import com.rizkir.domain.entities.MovieReviewEntity
import com.rizkir.domain.entities.MovieVideoEntity
import com.rizkir.domain.usecases.DetailMovieUseCase
import com.rizkir.domain.usecases.MovieReviewsUseCase
import com.rizkir.domain.usecases.MovieVideosUseCase

interface MovieCatalogueRepository {

    suspend fun fetchDetailMovie(params: DetailMovieUseCase.Params?): Flow<Result<DetailMovieEntity>>

    suspend fun fetchMovieVideos(params: MovieVideosUseCase.Params?): Flow<Result<List<MovieVideoEntity.Result>>>

    suspend fun fetchMovieReviews(params: MovieReviewsUseCase.Params?): Flow<Result<List<MovieReviewEntity>>>
}