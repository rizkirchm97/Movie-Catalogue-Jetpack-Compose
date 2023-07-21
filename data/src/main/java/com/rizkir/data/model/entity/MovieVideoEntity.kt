package com.rizkir.data.model.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.rizkir.domain.entities.MovieEntity

/**
 * created by RIZKI RACHMANUDIN on 20/07/2023
 */
@Entity(tableName = "MovieVideo", foreignKeys = [ForeignKey(
    entity = DiscoverMovieCacheEntity::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("id"),
    onDelete = ForeignKey.CASCADE
)])
data class MovieVideoEntity(
    @PrimaryKey(autoGenerate = false)
    val idResult: String,
    val id: Int,
    val key: String,
    val name: String,
    val site: String,
    val type: String
)
