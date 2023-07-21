package com.rizkir.data.model.dto.movie_reviews

import com.squareup.moshi.Json

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class ReviewResult(
    @field:Json(name = "author") val author: String,
    @field:Json(name = "author_details") val author_details: AuthorDetails,
    @field:Json(name = "content") val content: String,
    @field:Json(name = "id") val id: String,
    @field:Json(name = "url") val url: String
)
