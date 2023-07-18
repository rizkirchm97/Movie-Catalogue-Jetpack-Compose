package com.rizkir.data.datasources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rizkir.data.datasources.remote.ApiService
import com.rizkir.data.mapper.mapToEntity
import com.rizkir.data.model.movie_discover.MovieDiscoverResponse
import com.rizkir.data.model.movie_discover.MovieDiscoverResult
import com.rizkir.domain.entities.MovieEntity
import com.rizkir.domain.repositories.MovieCatalogueRepository
import com.rizkir.domain.usecases.DiscoverMovieUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataSource @Inject constructor(
    private val apiService: ApiService
) : PagingSource<Int, MovieEntity>() {
    override fun getRefreshKey(state: PagingState<Int, MovieEntity>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieEntity> {
        return try {
            val page = params.key ?: 1
            val response = apiService.fetchDiscoverMovie(page)
            LoadResult.Page(
                data = response.body()?.results?.map { it.mapToEntity() } as List<MovieEntity>,
                prevKey = null,
                nextKey = if (response.body()?.results?.isNotEmpty() == true) response.body()?.page?.plus(
                    1
                ) else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}