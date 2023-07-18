package com.rizkir.domain.usecases

import androidx.paging.PagingData
import com.rizkir.core.utils.Result
import com.rizkir.domain.entities.MovieEntity
import com.rizkir.domain.repositories.MovieCatalogueRepository
import com.rizkir.domain.utils.BaseUseCases
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DiscoverMovieUseCase @Inject constructor(
    private val movieCatalogueRepository: MovieCatalogueRepository
) : BaseUseCases<DiscoverMovieUseCase.Params, MovieEntity> {
    data class Params(val page: Int?)
    override suspend fun execute(params: DiscoverMovieUseCase.Params?): Flow<PagingData<MovieEntity>> {
        return movieCatalogueRepository.fetchDiscoverMovie(params?.page ?: 1)
    }
}