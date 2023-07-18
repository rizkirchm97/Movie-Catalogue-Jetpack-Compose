package com.rizkir.domain.entities

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class MovieImageEntity(
    val id: Int,
    val backdrops: List<Backdrop>,
    val posters: List<Poster>
)