package com.rizkir.domain.entities

import androidx.room.PrimaryKey

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class MovieReviewEntity(
    val idReview: String,
    val id: Int,
    val author: String?,
    val avatarPath: String?,
    val content: String?,
    val url: String?
)

