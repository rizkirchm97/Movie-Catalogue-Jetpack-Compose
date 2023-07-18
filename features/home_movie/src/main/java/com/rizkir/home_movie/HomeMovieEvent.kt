package com.rizkir.home_movie

sealed class HomeMovieEvent {
    object FetchMovies : HomeMovieEvent()
    object LoadMore : HomeMovieEvent()
}
