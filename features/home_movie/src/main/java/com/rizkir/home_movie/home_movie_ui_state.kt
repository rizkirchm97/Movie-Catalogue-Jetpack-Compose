
sealed interface HomeMovieUiState {
    data class Success(val data: List<Movie>) : HomeMovieUiState
    data class Error(val error: Throwable) : HomeMovieUiState
    object Loading : HomeMovieUiState
}