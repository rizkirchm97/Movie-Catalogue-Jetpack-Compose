package com.rizkir.domain.entities

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class MovieVideoEntity(
    val id: Int,
    val results: List<Result>
) {
    data class Result(
        val idResult: String,
        val id: Int,
        val key: String,
        val name: String,
        val site: String,
        val type: String
    )
}

