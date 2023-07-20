package com.rizkir.detail_movie

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.rizkir.core.utils.NetworkConnectivityObserver
import com.rizkir.core.utils.NetworkObserver
import com.rizkir.domain.entities.MovieEntity
import javax.inject.Inject

@Composable
fun DetailMovieRoute(
    onNavigatePopBack: () -> Unit,
    onRefresh: () -> Unit,
    context: Context
) {

    val networkObserver: NetworkObserver = NetworkConnectivityObserver(context)
    val stateNetwork = networkObserver.observe().collectAsStateWithLifecycle(initialValue = NetworkObserver.Status.Unavailable)

    DetailMovieRoute(
        stateNetwork = stateNetwork.value,
        onNavigatePopBack = onNavigatePopBack,
        onRefresh = onRefresh,
        state = ""

    )
}

@Composable
private fun DetailMovieRoute(
    stateNetwork: NetworkObserver.Status,
    onNavigatePopBack: () -> Unit,
    onRefresh: () -> Unit,
    state: String
) {
    DetailMovieScreen(
        stateNetwork = stateNetwork,
        state = state,
        onRefreshDetailMovie = onRefresh,
        onPopBack =  onNavigatePopBack
    )
}