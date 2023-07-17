package com.rizkir.data.model.movie_detail

import com.squareup.moshi.Json

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class Genre(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String
)
