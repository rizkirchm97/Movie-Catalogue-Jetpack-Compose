package com.rizkir.domain.entities

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class MovieEntity(
    val id: Int,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val original_language: String,
)
