package com.rizkir.detail_movie

/**
 * created by RIZKI RACHMANUDIN on 20/07/2023
 */
sealed class DetailMovieEvent {
    data class FetchMovieDetail(val movieId: Int): DetailMovieEvent()
    data class FetchMovieVideos(val movieId: Int) : DetailMovieEvent()
    data class FetchMovieReviews(val movieId: Int): DetailMovieEvent()
}
