package com.rizkir.detail_movie

import com.rizkir.domain.entities.DetailMovieEntity
import com.rizkir.domain.entities.MovieReviewEntity
import com.rizkir.domain.entities.MovieVideoEntity

/**
 * created by RIZKI RACHMANUDIN on 20/07/2023
 */
sealed interface DetailMovieUiState {
    val isLoading: Boolean
    val error: String

    data class Success(
        val dataDetail: DetailMovieEntity,
        val dataReview: List<MovieReviewEntity>,
        val dataVideo: List<MovieVideoEntity.Result>,
        override val isLoading: Boolean,
        override val error: String
    ) : DetailMovieUiState

    data class MovieDetailEmpty(
        override val isLoading: Boolean, override val error: String

    ) : DetailMovieUiState

    data class Error(override val error: String, override val isLoading: Boolean) : DetailMovieUiState

    data class HasMovieVideos(
        val data: List<MovieVideoEntity.Result>,
        override val isLoading: Boolean,
        override val error: String
    ) : DetailMovieUiState

    data class MovieVideosEmpty(
        override val isLoading: Boolean, override val error: String

    ) : DetailMovieUiState

    data class HasMovieReviews(
        val data: List<MovieReviewEntity>,
        override val isLoading: Boolean,
        override val error: String
    ) : DetailMovieUiState

    data class MovieReviewsEmpty(
        override val isLoading: Boolean, override val error: String

    ) : DetailMovieUiState

}