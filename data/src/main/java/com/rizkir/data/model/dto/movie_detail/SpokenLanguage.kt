package com.rizkir.data.model.dto.movie_detail

import com.squareup.moshi.Json

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class SpokenLanguage(
    @field:Json(name = "english_name") val english_name: String,
    @field:Json(name = "iso_639_1") val iso_639_1: String,
    @field:Json(name = "name") val name: String
)
