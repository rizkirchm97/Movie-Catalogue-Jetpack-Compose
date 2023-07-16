package com.rizkir.model

/**
 * created by RIZKI RACHMANUDIN on 16/07/2023
 */
data class MovieDiscoverResult(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)
