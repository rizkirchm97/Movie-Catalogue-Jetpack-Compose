
import androidx.compose.runtime.Composable
import com.rizkir.home_movie.HomeMovieUiState

@Composable
fun HomeMovieScreen(
    uiState: HomeMovieUiState,
    onMovieClick: (String) -> Unit,
    onRefreshUi: () -> Unit
) {
    HomeMovieScreen(
        uiState = uiState,
        onMovieClick = onMovieClick,
        onRefreshUi = onRefreshUi,
    )
}

@Composable
fun HomeMovieUiScreen() {
}