package com.rizkir.data.model.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.rizkir.domain.entities.MovieEntity

/**
 * created by RIZKI RACHMANUDIN on 20/07/2023
 */
@Entity(tableName = "MovieReviews", foreignKeys = [ForeignKey(
    entity = DiscoverMovieCacheEntity::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("id"),
    onDelete = ForeignKey.CASCADE
)])
data class MovieReviewsEntity(
    @PrimaryKey(autoGenerate = false)
    val idReview: String,
    val id: Int,
    val author: String,
    val avatarPath: String,
    val content: String,
    val url: String
)
