package com.rizkir.domain.entities

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class MovieVideoEntity(
    val id: Int,
    val results: List<Result>
) {
    data class Result(
        val id: String,
        val iso_3166_1: String,
        val iso_639_1: String,
        val key: String,
        val name: String,
        val site: String,
        val size: Int,
        val type: String
    )
}

