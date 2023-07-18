package com.rizkir.home_movie

import HomeMovieListScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.rizkir.domain.entities.MovieEntity

@Composable
fun HomeMovieRoute(
    viewModel: HomeMovieViewModel,
    onNavigateDetailMovie: () -> Unit
) {
    val uiState = viewModel.uiState.collectAsLazyPagingItems()
    val uiEvent = remember(viewModel) {
        val event: (HomeMovieEvent) -> Unit = { viewModel.event(it) }
        event
    }

    HomeMovieRoute(
        uiState = uiState,
        onNavigateDetailMovie = onNavigateDetailMovie,
        onRefreshMoviesList = {
            uiEvent(HomeMovieEvent.FetchMovies)
        }
    )
}

@Composable
private fun HomeMovieRoute(
    uiState: PagingData<MovieEntity>,
    onNavigateDetailMovie: () -> Unit,
    onRefreshMoviesList: () -> Unit
) {
    HomeMovieListScreen(
        uiState = uiState,
        onNavigateDetailMovie = onNavigateDetailMovie,
        onRefreshMovieList = onRefreshMoviesList
    )
}