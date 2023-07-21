package com.rizkir.detail_movie

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rizkir.core.utils.NetworkConnectivityObserver
import com.rizkir.core.utils.NetworkObserver
import com.rizkir.domain.entities.MovieEntity
import javax.inject.Inject

@Composable
fun DetailMovieRoute(
    viewModel: DetailMovieViewModel,
    movieId: Int,
    onNavigatePopBack: () -> Unit,
    onRefresh: () -> Unit,
    context: Context
) {


    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val uiEvent = remember(viewModel) {
        val event:(DetailMovieEvent) -> Unit = { viewModel.event(it) }
        event
    }

    uiEvent(DetailMovieEvent.FetchMovieDetail(movieId = movieId))
    uiEvent(DetailMovieEvent.FetchMovieReviews(movieId = movieId))
    uiEvent(DetailMovieEvent.FetchMovieVideos(movieId = movieId))

    val networkObserver: NetworkObserver = NetworkConnectivityObserver(context)
    val stateNetwork = networkObserver.observe().collectAsStateWithLifecycle(initialValue = NetworkObserver.Status.Unavailable)

    DetailMovieRoute(
        stateNetwork = stateNetwork.value,
        onNavigatePopBack = onNavigatePopBack,
        onRefresh = onRefresh,
        state = uiState

    )
}

@Composable
private fun DetailMovieRoute(
    stateNetwork: NetworkObserver.Status,
    onNavigatePopBack: () -> Unit,
    onRefresh: () -> Unit,
    state: DetailMovieUiState
) {
    DetailMovieScreen(
        stateNetwork = stateNetwork,
        state = state,
        onRefreshDetailMovie = onRefresh,
        onPopBack =  onNavigatePopBack
    )
}