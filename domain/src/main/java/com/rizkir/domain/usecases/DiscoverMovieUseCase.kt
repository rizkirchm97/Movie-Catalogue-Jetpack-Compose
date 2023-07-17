package com.rizkir.domain.usecases

import com.rizkir.core.utils.Result
import com.rizkir.domain.entities.MovieEntity
import com.rizkir.domain.repositories.MovieCatalogueRepository
import com.rizkir.domain.utils.BaseUseCases
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DiscoverMovieUseCase @Inject constructor(
    private val movieCatalogueRepository: MovieCatalogueRepository
) : BaseUseCases<DiscoverMovieUseCase.Params, List<MovieEntity>> {
    data class Params(val movieId: Int)
    override suspend fun execute(params: DiscoverMovieUseCase.Params?): Flow<Result<List<MovieEntity>>> {
        return movieCatalogueRepository.fetchDiscoverMovie()
    }
}