package com.rizkir.home_movie

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.rizkir.domain.entities.MovieEntity

@Composable
fun HomeMovieRoute(
    viewModel: HomeMovieViewModel,
    onNavigateDetailMovie: () -> Unit
) {

    val movieState = viewModel.moviePagingAsFlow.collectAsLazyPagingItems()


    HomeMovieRoute(
        onNavigateDetailMovie = onNavigateDetailMovie,
        onRefreshMoviesList = {
//            uiEvent(HomeMovieEvent.FetchMovies)
        },
        movieState = movieState

    )
}

@Composable
private fun HomeMovieRoute(
    onNavigateDetailMovie: () -> Unit,
    onRefreshMoviesList: () -> Unit,
    movieState: LazyPagingItems<MovieEntity>
) {
    HomeMovieListScreen(
        onNavigateDetailMovie = onNavigateDetailMovie,
        onRefreshMovieList = onRefreshMoviesList,
        movieState = movieState
    )
}