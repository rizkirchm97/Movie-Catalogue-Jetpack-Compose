
import androidx.compose.runtime.Composable

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