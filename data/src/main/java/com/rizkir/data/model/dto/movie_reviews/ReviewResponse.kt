package com.rizkir.data.model.dto.movie_reviews

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class ReviewResponse(
    val id: Int,
    val page: Int,
    val results: List<ReviewResult>,
    val total_pages: Int,
    val total_results: Int
)