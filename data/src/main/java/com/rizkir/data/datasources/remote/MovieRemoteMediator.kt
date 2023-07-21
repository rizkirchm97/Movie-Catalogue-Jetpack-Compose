package com.rizkir.data.datasources.remote

import com.rizkir.data.model.entity.RemoteKeyEntity
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.rizkir.data.datasources.local.db.MovieDatabase
import com.rizkir.data.mapper.mapToCachedEntity2
import com.rizkir.data.model.entity.DiscoverMovieCacheEntity
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalPagingApi::class)
class MovieRemoteMediator(
    private val movieDb: MovieDatabase,
    private val apiService: ApiService
) : RemoteMediator<Int, DiscoverMovieCacheEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, DiscoverMovieCacheEntity>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextKey?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevKey = remoteKeys?.prevKey
                    prevKey ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                }

                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextKey = remoteKeys?.nextKey
                    nextKey ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                }
            }
            Timber.tag("LoadKey").e("$loadKey")


                val apiResponse = apiService.fetchDiscoverMovie(page = loadKey)

                val movies = apiResponse.body()?.results
                val endOfPaginationReached = movies?.isEmpty()

                movieDb.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        movieDb.movieDao.deleteAll()
                        movieDb.remoteKeyDao.clearRemoteKeys()
                    }

                    val prevKey = if (loadKey > 1) loadKey - 1 else null
                    val nextKey = if (endOfPaginationReached == true) null else loadKey + 1
                    val remoteKey = movies?.map {
                        RemoteKeyEntity(
                            movieID = it.id,
                            prevKey = prevKey,
                            currentPage = loadKey,
                            nextKey = nextKey
                        )
                    }

                    remoteKey?.let { movieDb.remoteKeyDao.insertAll(it) }
                    val movieEntity = movies?.map { movie -> movie.mapToCachedEntity2(loadKey)}
                    movieEntity?.let { movieDb.movieDao.upsertAll(it) }

                }

            MediatorResult.Success(
                endOfPaginationReached = endOfPaginationReached!!
            )
        } catch (e: IOException) {
            Timber.e(e.localizedMessage)
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            Timber.e(e.message)
            MediatorResult.Error(e)
        }
    }

    override suspend fun initialize(): InitializeAction {
        val cacheTimeOut = TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS)
        return if (System.currentTimeMillis() - (movieDb.remoteKeyDao.getCreationTime() ?: 0) < cacheTimeOut) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, DiscoverMovieCacheEntity>): RemoteKeyEntity? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                movieDb.remoteKeyDao.getRemoteKeyByMovieID(id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, DiscoverMovieCacheEntity>): RemoteKeyEntity? {
        return state.pages.firstOrNull {
            it.data.isNotEmpty()
        }?.data?.firstOrNull()?.let { movie ->
            movieDb.remoteKeyDao.getRemoteKeyByMovieID(movie.id)
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, DiscoverMovieCacheEntity>): RemoteKeyEntity? {
        return state.pages.lastOrNull {
            it.data.isNotEmpty()
        }?.data?.lastOrNull()?.let { movie ->
            movieDb.remoteKeyDao.getRemoteKeyByMovieID(movie.id)
        }
    }

}