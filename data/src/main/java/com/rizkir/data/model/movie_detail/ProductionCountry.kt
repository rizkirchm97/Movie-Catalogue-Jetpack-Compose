package com.rizkir.data.model.movie_detail

import com.squareup.moshi.Json

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class ProductionCountry(
    @field:Json(name = "iso_3166_1") val iso_3166_1: String,
    @field:Json(name = "name") val name: String
)
