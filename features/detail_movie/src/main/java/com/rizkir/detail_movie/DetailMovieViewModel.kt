package com.rizkir.detail_movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rizkir.domain.entities.DetailMovieEntity
import com.rizkir.domain.entities.MovieReviewEntity
import com.rizkir.domain.entities.MovieVideoEntity
import com.rizkir.domain.usecases.DetailMovieUseCase
import com.rizkir.domain.usecases.MovieReviewsUseCase
import com.rizkir.domain.usecases.MovieVideosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.rizkir.core.utils.Result
import kotlinx.coroutines.flow.update

/**
 * created by RIZKI RACHMANUDIN on 20/07/2023
 */

@HiltViewModel
class DetailMovieViewModel @Inject constructor(
    private val detailMovieUseCase: DetailMovieUseCase,
    private val movieVideosUseCase: MovieVideosUseCase,
    private val movieReviewsUseCase: MovieReviewsUseCase
) : ViewModel() {

    val event: (DetailMovieEvent) -> Unit

    private val state = MutableStateFlow(DetailMovieViewModelState(isLoading = true))

    val  uiState = state
        .map (DetailMovieViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            state.value.toUiState()
        )

    init {
        event = {
            when (it) {
                is DetailMovieEvent.FetchMovieDetail -> fetchMovieDetail(it.movieId)
                is DetailMovieEvent.FetchMovieVideos -> fetchMovieVideos(it.movieId)
                is DetailMovieEvent.FetchMovieReviews -> fetchMovieReviews(it.movieId)
            }
        }
    }

    private fun fetchMovieDetail(movieId: Int) {
        viewModelScope.launch {
            detailMovieUseCase.execute(DetailMovieUseCase.Params(movieId)).collect { response ->
                when(response){
                    is Result.Error -> state.update {
                        it.copy(error = response.message)
                    }
                    is Result.Loading -> state.update {
                        it.copy(error = "", isLoading = response.loading)
                    }
                    is Result.Success -> state.update {
                        it.copy(movieDetail = response.data)
                    }
                }

            }
        }
    }

    private fun fetchMovieVideos(movieId: Int) {
        viewModelScope.launch {
            movieVideosUseCase.execute(MovieVideosUseCase.Params(movieId)).collect { response ->
                when(response){
                    is Result.Error -> state.update {
                        it.copy(error = response.message)
                    }
                    is Result.Loading -> state.update {
                        it.copy(error = "", isLoading = response.loading)
                    }
                    is Result.Success -> state.update {
                        it.copy(movieVideos = response.data)
                    }
                }

            }
        }
    }

    private fun fetchMovieReviews(movieId: Int) {
        viewModelScope.launch {
            movieReviewsUseCase.execute(MovieReviewsUseCase.Params(movieId)).collect { response ->
                when(response){
                    is Result.Error -> state.update {
                        it.copy(error = response.message)
                    }
                    is Result.Loading -> state.update {
                        it.copy(error = "", isLoading = response.loading)
                    }
                    is Result.Success -> state.update {
                        it.copy(movieReviews = response.data)
                    }
                }

            }
        }
    }

}

private data class DetailMovieViewModelState(
    val isLoading: Boolean = false,
    val error: String = "",
    val movieDetail: DetailMovieEntity? = null,
    val movieVideos: List<MovieVideoEntity.Result> = emptyList(),
    val movieReviews: List<MovieReviewEntity> = emptyList()
) {
    fun toUiState(): DetailMovieUiState {
        return when {
            movieDetail != null -> DetailMovieUiState.Success(
                isLoading = isLoading,
                dataDetail = movieDetail,
                dataReview = movieReviews,
                dataVideo = movieVideos,
                error = error
            )

            else -> DetailMovieUiState.Error(isLoading = isLoading, error = error)
        }
    }
}