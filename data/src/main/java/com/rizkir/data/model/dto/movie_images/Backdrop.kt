package com.rizkir.data.model.dto.movie_images

import com.squareup.moshi.Json

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class Backdrop(
    @field:Json(name = "aspect_ratio") val aspect_ratio: Double,
    @field:Json(name = "file_path") val file_path: String,
    @field:Json(name = "height") val height: Int,
    @field:Json(name = "iso_639_1") val iso_639_1: Any,
    @field:Json(name = "vote_average") val vote_average: Double,
    @field:Json(name = "vote_count") val vote_count: Int,
    @field:Json(name = "width") val width: Int
)
