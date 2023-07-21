package com.rizkir.home_movie

import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.rizkir.domain.entities.MovieEntity

@Composable
fun HomeMovieRoute(
    viewModel: HomeMovieViewModel,
    onNavigateDetailMovie: (Int) -> Unit
) {

    val movieState = viewModel.moviePagingAsFlow.collectAsLazyPagingItems()


    HomeMovieRoute(
        onNavigateDetailMovie = { params -> onNavigateDetailMovie(params) },
        onRefreshMoviesList = {
//            uiEvent(HomeMovieEvent.FetchMovies)
        },
        movieState = movieState

    )
}

@Composable
private fun HomeMovieRoute(
    onNavigateDetailMovie: (Int) -> Unit,
    onRefreshMoviesList: () -> Unit,
    movieState: LazyPagingItems<MovieEntity>
) {
    HomeMovieListScreen(
        onNavigateDetailMovie = {params -> onNavigateDetailMovie(params)},
        onRefreshMovieList = onRefreshMoviesList,
        movieState = movieState
    )
}