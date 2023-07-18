package com.rizkir.domain.usecases

import com.rizkir.core.utils.Result
import com.rizkir.domain.entities.MovieEntity
import com.rizkir.domain.entities.MovieReviewEntity
import com.rizkir.domain.repositories.MovieCatalogueRepository
import com.rizkir.domain.utils.BaseUseCases
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
class MovieReviewsUseCase @Inject constructor(
    private val movieCatalogueRepository: MovieCatalogueRepository
) : BaseUseCases<MovieReviewsUseCase.Params, MovieReviewEntity> {
    data class Params(val movieId: Int)
    override suspend fun execute(params: MovieReviewsUseCase.Params?): Flow<Result<MovieReviewEntity>> {
        return movieCatalogueRepository.fetchMovieReviews(params)
    }
}

