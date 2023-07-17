package com.rizkir.domain.usecases

import com.rizkir.core.utils.Result
import com.rizkir.domain.entities.MovieEntity
import com.rizkir.domain.entities.MovieImageEntity
import com.rizkir.domain.repositories.MovieCatalogueRepository
import com.rizkir.domain.utils.BaseUseCases
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
class MovieImageUseCase @Inject constructor(
    private val movieCatalogueRepository: MovieCatalogueRepository
) : BaseUseCases<MovieImageUseCase.Params, List<MovieImageEntity>> {
    data class Params(val movieId: Int)
    override suspend fun execute(params: MovieImageUseCase.Params?): Flow<Result<List<MovieImageEntity>>> {
        return movieCatalogueRepository.fetchMovieImages(params)
    }
}
