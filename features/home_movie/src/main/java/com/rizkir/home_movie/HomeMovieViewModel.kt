package com.rizkir.home_movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.rizkir.data.mapper.mapToEntity
import com.rizkir.data.model.entity.DiscoverMovieCacheEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/***
 * I don't know, there is @param[pager] injected into ViewModel
 * constructor that probably should be mapping at data layer as Uncle Bob mentioned
 * but at this time, i still don't find the exact best practice which one to use.
 */
@HiltViewModel
class HomeMovieViewModel @Inject constructor(
    pager: Pager<Int, DiscoverMovieCacheEntity>
) : ViewModel() {

//    val event: (HomeMovieEvent) -> Unit

    val moviePagingAsFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map { it.mapToEntity() }
        }
        .cachedIn(viewModelScope)

    init {
//        event = {
//            when(it) {
//                HomeMovieEvent.FetchMovies -> moviePagingAsFlow
//                else -> Unit
//            }
//        }
    }



}