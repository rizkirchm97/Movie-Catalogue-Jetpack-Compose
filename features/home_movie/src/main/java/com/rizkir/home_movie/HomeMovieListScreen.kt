import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import coil.compose.rememberAsyncImagePainter
import com.rizkir.core.components.ApplicationAppbar
import com.rizkir.core.components.CircularProgressBar
import com.rizkir.core.components.NetworkErrorMessage
import com.rizkir.core.utils.ImageConfig
import com.rizkir.di.utils.ImageBaseUrl
import com.rizkir.domain.entities.MovieEntity
import com.rizkir.home_movie.HomeMovieUiState
import javax.inject.Inject

@Composable
fun HomeMovieListScreen(
    uiState: PagingData<MovieEntity>,
    onNavigateDetailMovie: () -> Unit,
    onRefreshMovieList: () -> Unit
) {
    HomeMovieListScreen(
        uiState = uiState,
        hasMovieList = { dataItem, modifier ->
            HomeMovieListItem(
                modifier = modifier,
                dataItem = dataItem,
                onItemClick = onNavigateDetailMovie
            )
        },
        onRefreshList = onRefreshMovieList,
    )
}

@Composable
private fun HomeMovieListScreen(
    uiState: PagingData<MovieEntity>,
    hasMovieList: @Composable (dataItem: MovieEntity, modifier: Modifier) -> Unit,
    onRefreshList: () -> Unit
) {
    Scaffold(topBar = { ApplicationAppbar(title = "Movie Catalogue") }) {
        val modifier = Modifier.padding(it)
        LoadingComponent(
            isLoading = uiState.,
            loadingContent = { CircularProgressBar() },
            content = {
                when (uiState) {
                    is HomeMovieUiState.HasMovieList -> {
                        LazyVerticalGrid(
                            columns = GridCells.Adaptive(minSize = 125.dp)
                        ) {
                            items(items = uiState.data) { dataItem ->
                                hasMovieList(dataItem = dataItem, modifier = modifier)
                            }
                        }
                    }

                    is HomeMovieUiState.MovieListEmpty -> {
                        if (uiState.error.isNotEmpty()) {
                            NetworkErrorMessage(
                                message = uiState.error,
                                onClickRefresh = onRefreshList
                            )
                        } else {
                            Text(text = "Nothing to show")
                        }
                    }

                    else -> Unit
                }
            }
        )
    }

}

@Composable
fun LoadingComponent(
    isLoading: Boolean,
    loadingContent: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    if (isLoading) loadingContent()
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

        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Image(
                painter = rememberAsyncImagePainter(model = "${ImageConfig.imageBaseUrl}${dataItem.poster_path}"),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1f)

            )
        }

        

    }
}

