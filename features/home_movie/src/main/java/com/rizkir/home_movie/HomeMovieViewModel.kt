package com.rizkir.home_movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.rizkir.core.utils.Result
import com.rizkir.domain.entities.MovieEntity
import com.rizkir.domain.usecases.DiscoverMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeMovieViewModel @Inject constructor(
    private val movieUseCase: DiscoverMovieUseCase
) : ViewModel() {
    val event: (HomeMovieEvent) -> Unit

    private val state = MutableStateFlow<PagingData<MovieEntity>>(PagingData.empty())
    val uiState = state
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            state.value
        )

    init {
        event = {
            when(it) {
                HomeMovieEvent.FetchMovies -> fetchMovies()
                else -> Unit
            }
        }
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            movieUseCase.execute(null).collect { result ->
                state.update {
                    result
                }

//                when(result) {
//                    is Result.Success -> state.update {
//                        it.copy(error = result.message)
//                    }
//                    is Result.Loading -> state.update {
//                        it.copy(error = "", isLoading = result.loading)
//                    }
//                    is Result.Success -> state.update {
//                        it.copy(movieEntity = result.data)
//                    }
//                }

            }
        }
    }


}

private data class HomeViewModelState(
    val isLoading: Boolean = false,
    val error: String = "",
    val movieEntity: PagingData<MovieEntity>? = null
) {
    fun toUiState(): HomeMovieUiState =
        if (movieEntity != null) HomeMovieUiState.MovieListEmpty(
            isLoading = isLoading,
            error = error
        )
        else HomeMovieUiState.HasMovieList(isLoading = isLoading, error = error, data = movieEntity )
}