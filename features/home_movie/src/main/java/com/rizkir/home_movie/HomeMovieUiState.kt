package com.rizkir.home_movie

import androidx.paging.PagingData
import com.rizkir.domain.entities.MovieEntity

sealed interface HomeMovieUiState {
    val isLoading: Boolean
    val error: String

    data class HasMovieList(
        val data: List<MovieEntity>,
        override val isLoading: Boolean,
        override val error: String
    ) : HomeMovieUiState

    data class MovieListEmpty(
        override val isLoading: Boolean, override val error: String

    ) : HomeMovieUiState

    data class Error(override val error: String, override val isLoading: Boolean) : HomeMovieUiState
}