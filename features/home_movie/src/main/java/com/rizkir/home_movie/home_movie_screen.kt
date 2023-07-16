
@Composable
fun HomeMovieScreen(
    uiState: HomeMovieUiState,
    onMovieClick: (Movie) -> Unit,
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