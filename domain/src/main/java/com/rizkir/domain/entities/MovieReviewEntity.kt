package com.rizkir.domain.entities

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class MovieReviewEntity(
    val id: Int,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
) {
    data class Result(
        val author: String,
        val author_details: AuthorDetails,
        val content: String,
        val id: String,
        val url: String
    ) {
        data class AuthorDetails(
            val avatar_path: String,
            val name: String,
            val rating: Any,
            val username: String
        )
    }
}

