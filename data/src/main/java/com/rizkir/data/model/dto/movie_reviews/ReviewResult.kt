package com.rizkir.data.model.dto.movie_reviews

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class ReviewResult(
    val author: String,
    val author_details: AuthorDetails,
    val content: String,
    val id: String,
    val url: String
)
