package com.rizkir.detail_movie

import android.net.Network
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.rizkir.core.components.ApplicationAppbar
import com.rizkir.core.components.CircularProgressBar
import com.rizkir.core.components.NetworkErrorMessage
import com.rizkir.core.components.VideoWebViewCompose
import com.rizkir.core.utils.NetworkConnectivityObserver
import com.rizkir.core.utils.NetworkObserver
import com.rizkir.core.utils.message

@Composable
fun DetailMovieScreen(
    stateNetwork: NetworkObserver.Status,
    state: String,
    onRefreshDetailMovie: () -> Unit,
    onPopBack: () -> Unit
) {
    DetailMovieScreen(
        state = state,
        stateNetwork = stateNetwork,
        onRefreshScreen = onRefreshDetailMovie,
        success = { data, stateNetwork, modifier ->
            DetailMovieContentView(data, stateNetwork, modifier)
        },
        error = { message ->
            NetworkErrorMessage(message = message) {
            }

        },
        onPopBack = onPopBack
    )
}


@Composable
fun DetailMovieContentView(data: String, stateNetwork: NetworkObserver.Status, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .background(Color.White)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (stateNetwork.name == NetworkObserver.Status.Available.name) {
            VideoWebViewCompose("gxWcfz3V2QE", modifier = modifier)
        } else {
            Text(text = "No Connection")
        }
        Spacer(modifier = modifier.height(12.dp))


    }

}



@Composable
private fun DetailMovieScreen(
    state: String,
    stateNetwork: NetworkObserver.Status,
    onRefreshScreen: () -> Unit,
    onPopBack: () -> Unit,
    success: @Composable (data: String, stateNetwork: NetworkObserver.Status,  modifier: Modifier) -> Unit,
    error: @Composable (message: String) -> Unit
) {
    Scaffold(topBar = {
        ApplicationAppbar(title = "Detail Movie", onClickBack = onPopBack)
    }) {
        val modifier = Modifier.padding(it)
        LoadingScreen(
            isLoading = false,
            loadingContent = { CircularProgressBar() },
            content = {
                success(state, stateNetwork, modifier)
            }
        )
    }
}

@Composable
fun LoadingScreen(
    isLoading: Boolean,
    loadingContent: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    if (isLoading) loadingContent()
    else content()
}
