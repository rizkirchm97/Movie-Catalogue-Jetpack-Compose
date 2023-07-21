package com.rizkir.data.model.dto.movie_reviews

import com.squareup.moshi.Json

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class ReviewResponse(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "page") val page: Int,
    @field:Json(name = "results") val results: List<ReviewResult>,
    @field:Json(name = "total_pages") val total_pages: Int,
    @field:Json(name = "total_results")val total_results: Int
)