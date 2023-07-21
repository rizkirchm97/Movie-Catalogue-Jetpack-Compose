package com.rizkir.data.model.dto.movie_reviews

import com.squareup.moshi.Json

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class AuthorDetails(
    @field:Json(name = "avatar_path") val avatar_path: String?,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "rating") val rating: Double?,
    @field:Json(name = "username") val username: String?
)
