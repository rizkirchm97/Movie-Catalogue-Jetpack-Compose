package com.rizkir.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DiscoverMovieCacheEntity(
    val adult: Boolean?,
    val backdropPath: String?,
    val genreIds: String?,
    @PrimaryKey
    val id: Int,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val popularity: String?,
    val posterPath: String?,
    val releaseDate: String?,
    val title: String?,
    val video: Boolean?,
    val voteAverage: String?,
    val voteCount: Int?,
    var page: Int?
)
