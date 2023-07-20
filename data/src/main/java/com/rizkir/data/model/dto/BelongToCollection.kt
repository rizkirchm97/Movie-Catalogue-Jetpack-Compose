package com.rizkir.data.model.dto

import com.squareup.moshi.Json

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class BelongToCollection(
    @field:Json(name = "backdrop_path") val backdrop_path: String,
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "poster_path") val poster_path: String
)
