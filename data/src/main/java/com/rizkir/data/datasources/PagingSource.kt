package com.rizkir.data.datasources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rizkir.data.datasources.remote.ApiService
import com.rizkir.data.mapper.mapToCachedEntity2
import com.rizkir.data.mapper.mapToEntity
import com.rizkir.domain.entities.MovieEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PagingSource @Inject constructor(
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
                data = response.body()?.results?.map { it.mapToCachedEntity2(response.body()!!.page)} as List<MovieEntity>,
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