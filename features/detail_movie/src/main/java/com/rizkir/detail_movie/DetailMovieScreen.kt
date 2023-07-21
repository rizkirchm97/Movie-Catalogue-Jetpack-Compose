package com.rizkir.detail_movie

import android.net.Network
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Divider
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.Coil
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.rizkir.core.components.ApplicationAppbar
import com.rizkir.core.components.CircularProgressBar
import com.rizkir.core.components.NetworkErrorMessage
import com.rizkir.core.components.VideoWebViewCompose
import com.rizkir.core.utils.ImageConfig
import com.rizkir.core.utils.NetworkConnectivityObserver
import com.rizkir.core.utils.NetworkObserver
import com.rizkir.core.utils.message
import com.rizkir.domain.entities.DetailMovieEntity
import com.rizkir.domain.entities.MovieReviewEntity
import com.rizkir.domain.entities.MovieVideoEntity

@Composable
fun DetailMovieScreen(
    stateNetwork: NetworkObserver.Status,
    state: DetailMovieUiState,
    onRefreshDetailMovie: () -> Unit,
    onPopBack: () -> Unit
) {
    DetailMovieScreen(
        state = state,
        stateNetwork = stateNetwork,
        onRefreshScreen = onRefreshDetailMovie,
        success = { dataDetail, dataReviews, dataVideos, stateNetwork, modifier ->
            DetailMovieContentView(dataDetail, dataReviews, dataVideos, stateNetwork, modifier)
        },
        error = { message ->
            NetworkErrorMessage(message = message) {}

        },
        onPopBack = onPopBack
    )
}


@Composable
fun DetailMovieContentView(
    dataDetail: DetailMovieEntity,
    dataReviews: List<MovieReviewEntity>,
    dataVideo: List<MovieVideoEntity.Result>,
    stateNetwork: NetworkObserver.Status,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp).background(Color.White)
    ) {

        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data("${ImageConfig.imageBaseUrl}${dataDetail.poster_path}")
                .size(coil.size.Size.ORIGINAL).build(),
        )
        Log.e("painterPath: ", "${ImageConfig.imageBaseUrl}${dataDetail.poster_path}")
        Log.e("painterState: ", "${painter.state}")

        if (stateNetwork.name == NetworkObserver.Status.Available.name) {
            if (dataVideo.isNotEmpty()) {
                Log.e("inUI, dataVideo", "${dataVideo[0].key} ?: ")
                VideoWebViewCompose(dataVideo[0].key, modifier = modifier.height(50.dp))
            }

        } else {
            Text(text = "No Connection")
        }

        Spacer(modifier = modifier.height(16.dp))
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            item {
                Row(modifier = modifier.fillMaxWidth()) {

                    if (painter.state is AsyncImagePainter.State.Loading) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_broken_image_24),
                            contentScale = ContentScale.Crop,
                            contentDescription = dataDetail.title,
                            modifier = modifier.fillMaxHeight().width(100.dp)
                        )
                    } else {
                        Image(
                            painter = painter,
                            contentScale = ContentScale.Crop,
                            contentDescription = dataDetail.title,
                            modifier = Modifier.fillMaxHeight().width(104.dp)
                                .clip(RoundedCornerShape(8.dp))
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(text = dataDetail.title, style = MaterialTheme.typography.titleMedium)
                        Text(
                            text = dataDetail.release_date,
                            style = MaterialTheme.typography.titleSmall,
                            color = Color.LightGray
                        )
                        Text(text = dataDetail.overview, style = MaterialTheme.typography.bodySmall)

                        Spacer(modifier = Modifier.height(16.dp))
                        for (genre in dataDetail.genre.split(",")) {
                            Row(modifier = Modifier) {
                                if (genre.length <= 6) {
                                    Text(
                                        text = genre,
                                        style = MaterialTheme.typography.bodySmall,
                                        fontSize = 10.sp,
                                        overflow = TextOverflow.Ellipsis,
                                        modifier = Modifier.background(
                                            Color.Cyan, RoundedCornerShape(8.dp)
                                        ).padding(8.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))

                                }
                                Spacer(modifier = Modifier)
                                Column(modifier = Modifier.fillMaxWidth()) {
                                    if (genre.length > 6) {
                                        Text(
                                            text = genre,
                                            style = MaterialTheme.typography.bodySmall,
                                            fontSize = 10.sp,
                                            maxLines = 6,
                                            overflow = TextOverflow.Ellipsis,
                                            modifier = Modifier.background(
                                                Color.Cyan, RoundedCornerShape(8.dp)
                                            ).padding(8.dp)
                                        )
                                        Spacer(modifier = Modifier.height(4.dp))
                                    }
                                }


                            }
                        }


                    }
                }
                Divider(modifier = modifier.padding(vertical = 8.dp))
                Text(text = "Reviews", style = MaterialTheme.typography.headlineSmall)
            }
            if (dataReviews.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier.fillMaxWidth().height(100.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Text(
                            text = "No Reviews",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }


                }
            } else {
                items(dataReviews) { item ->
                    ReviewerItem(data = item, modifier = Modifier.padding(vertical = 8.dp))
                }
            }

        }

    }


}


@Composable
private fun ReviewerItem(modifier: Modifier = Modifier, data: MovieReviewEntity) {
    Column(modifier = modifier) {
        data.author?.let { Text(text = it, style = MaterialTheme.typography.titleSmall) }
        Box(
            modifier = modifier.fillMaxWidth().background(Color.Cyan, shape = RoundedCornerShape(4))
                .padding(16.dp)
        ) {
            data.content?.let { Text(text = it, style = MaterialTheme.typography.bodySmall) }
        }
        Divider(modifier = modifier.padding(vertical = 8.dp))
    }
}

@Composable
private fun DetailMovieScreen(
    state: DetailMovieUiState,
    stateNetwork: NetworkObserver.Status,
    onRefreshScreen: () -> Unit,
    onPopBack: () -> Unit,
    success: @Composable (dataDetail: DetailMovieEntity, dataReviews: List<MovieReviewEntity>, dataVideo: List<MovieVideoEntity.Result>, stateNetwork: NetworkObserver.Status, modifier: Modifier) -> Unit,
    error: @Composable (message: String) -> Unit
) {
    Scaffold(topBar = {
        ApplicationAppbar(title = "Detail Movie", onClickBack = onPopBack)
    }) {
        val modifier = Modifier.padding(it)
        LoadingScreen(isLoading = state.isLoading,
            stateNetwork,
            loadingContent = { CircularProgressBar() },
            content = {
                when (state) {
                    is DetailMovieUiState.Success -> {
                        success(
                            state.dataDetail,
                            state.dataReview,
                            state.dataVideo,
                            stateNetwork,
                            modifier
                        )
                    }

                    is DetailMovieUiState.Error -> {
                        error(state.error)
                    }

                    else -> {
                        error("Unknown Error")
                    }
                }
            })
    }
}

@Composable
fun LoadingScreen(
    isLoading: Boolean,
    networkState: NetworkObserver.Status,
    loadingContent: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    if (isLoading && networkState.name == NetworkObserver.Status.Available.name) loadingContent()
    else content()
}
