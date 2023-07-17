package com.rizkir.domain.entities

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class MovieImageEntity(
    val id: Int,
    val backdrops: List<Backdrop>,
    val posters: List<Poster>
) {
    data class Backdrop(
        val aspect_ratio: Double,
        val file_path: String,
        val height: Int,
        val iso_639_1: Any,
        val vote_average: Double,
        val vote_count: Int,
        val width: Int
    )

    data class Poster(
        val aspect_ratio: Double,
        val file_path: String,
        val height: Int,
        val iso_639_1: String,
        val vote_average: Double,
        val vote_count: Int,
        val width: Int
    )
}
