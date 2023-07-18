package com.rizkir.data.model.movie_videos

import com.squareup.moshi.Json

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class DetailMovieVideos(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "results") val results: List<DetailMovieVideosResult>
)
