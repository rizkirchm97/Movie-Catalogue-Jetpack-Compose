
sealed interface HomeMovieUiState {
    data class Success(val data: List<String>) : HomeMovieUiState
    data class Error(val error: Throwable) : HomeMovieUiState
    object Loading : HomeMovieUiState
}