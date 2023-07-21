package com.rizkir.domain.usecases;

import com.rizkir.core.utils.Result
import com.rizkir.domain.entities.MovieEntity
import com.rizkir.domain.entities.MovieVideoEntity
import com.rizkir.domain.repositories.MovieCatalogueRepository
import com.rizkir.domain.utils.BaseUseCases
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject;

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
class MovieVideosUseCase @Inject constructor(
    private val movieCatalogueRepository: MovieCatalogueRepository
) : BaseUseCases<MovieVideosUseCase.Params, List<MovieVideoEntity.Result>> {
    data class Params(val movieId: Int)

    override suspend fun execute(params: MovieVideosUseCase.Params?): Flow<Result<List<MovieVideoEntity.Result>>> {
        return movieCatalogueRepository.fetchMovieVideos(params)
    }
}

