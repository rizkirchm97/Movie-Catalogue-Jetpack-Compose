package com.rizkir.data.model.movie_discover

import com.squareup.moshi.Json

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class MovieDiscoverResponse(
    @field:Json(name = "page") val page: Int,
    @field:Json(name = "results") val results: List<MovieDiscoverResult>,
    @field:Json(name = "total_pages")val total_pages: Int,
    @field:Json(name = "total_results") val total_results: Int
)

