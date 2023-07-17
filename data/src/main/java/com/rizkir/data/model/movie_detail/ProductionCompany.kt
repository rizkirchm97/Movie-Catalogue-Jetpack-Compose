package com.rizkir.data.model.movie_detail

import com.squareup.moshi.Json

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class ProductionCompany(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "logo_path") val logo_path: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "origin_country") val origin_country: String
)
