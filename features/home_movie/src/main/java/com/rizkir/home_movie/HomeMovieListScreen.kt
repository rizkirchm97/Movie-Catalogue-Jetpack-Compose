package com.rizkir.home_movie

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.rizkir.core.components.ApplicationAppbar
import com.rizkir.core.components.CircularProgressBar
import com.rizkir.core.components.NetworkErrorMessage
import com.rizkir.core.utils.ImageConfig
import com.rizkir.domain.entities.MovieEntity

@Composable
fun HomeMovieListScreen(
    onNavigateDetailMovie: () -> Unit,
    onRefreshMovieList: () -> Unit,
    movieState: LazyPagingItems<MovieEntity>
) {
    HomeMovieListScreen(
        hasMovieList = { dataItem, modifier ->
            HomeMovieListItem(
                modifier = modifier,
                dataItem = dataItem,
                onItemClick = onNavigateDetailMovie
            )
        },
        onRefreshList = onRefreshMovieList,
        movieState = movieState
    )
}

@Composable
private fun HomeMovieListScreen(
    hasMovieList: @Composable (dataItem: MovieEntity, modifier: Modifier) -> Unit,
    onRefreshList: () -> Unit,
    movieState: LazyPagingItems<MovieEntity>
) {
    Scaffold(topBar = { ApplicationAppbar(title = "Movie Catalogue") }) {
        val modifier = Modifier.padding(it)
        LoadingComponent(
            movieState.loadState,
            loadingContent = { CircularProgressBar() },
            content = {

                val modifier = Modifier.padding(it)
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 150.dp),
                ) {
                    items(count = movieState.itemCount) { index ->
                        val dataItem = movieState[index]
                        Log.e("DataItemInUi", "$dataItem")
                        if (dataItem != null) {
                            hasMovieList(dataItem = dataItem, modifier = modifier)
                        }
                    }

                    item {
                        if (movieState.loadState.append is LoadState.Loading) {
                            CircularProgressBar()
                        }
                    }
                }

                if (movieState.loadState.refresh is LoadState.Error || movieState.loadState.append is LoadState.Error) {
                    NetworkErrorMessage(
                        message = "Error occurred : ${(movieState.loadState.refresh as LoadState.Error).error.message}",
                        onClickRefresh = onRefreshList
                    )


                }


            }
        )
    }

}

@Composable
fun LoadingComponent(
    isPagingLoading: CombinedLoadStates,
    loadingContent: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    if (isPagingLoading.refresh is LoadState.Loading) loadingContent()
    else content()
}


@Composable
fun HomeMovieListItem(
    modifier: Modifier = Modifier,
    dataItem: MovieEntity,
    onItemClick: () -> Unit
) {
    Card(

        modifier = modifier
            .padding(16.dp)
            .clickable {
                onItemClick()
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(size = 4.dp)

    ) {


        val painter = rememberAsyncImagePainter(
            model = "${ImageConfig.imageBaseUrl}${dataItem.poster_path}",
        )



        if (painter.state is AsyncImagePainter.State.Empty || painter.state is AsyncImagePainter.State.Error) {
            Text(
                text = "No Image",
                modifier = modifier.fillMaxSize()
            )
        } else {
            Image(
                painter = painter,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1f)

            )
        }


//        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {

//        }


    }
}

