package com.rizkir.data.model.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.rizkir.data.model.dto.movie_detail.Genre
import com.rizkir.data.model.dto.movie_detail.ProductionCompany
import com.rizkir.data.model.dto.movie_detail.ProductionCountry
import com.rizkir.data.model.dto.movie_detail.SpokenLanguage
import com.rizkir.domain.entities.MovieEntity
import com.squareup.moshi.Json

/**
 * created by RIZKI RACHMANUDIN on 20/07/2023
 */

@Entity(tableName = "MovieDetail", foreignKeys = [ForeignKey(
    entity = DiscoverMovieCacheEntity::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("id"),
    onDelete = ForeignKey.CASCADE
)]
)
data class MovieDetailEntity(
    val adult: Boolean,
    val backdrop_path: String,
    val genres: String,
    val budget: Int,
    val homepage: String,
    val id: Int,
    @PrimaryKey(autoGenerate = false)
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)
