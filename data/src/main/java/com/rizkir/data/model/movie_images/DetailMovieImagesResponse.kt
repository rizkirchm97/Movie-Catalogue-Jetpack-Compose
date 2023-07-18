package com.rizkir.data.model.movie_images

import com.squareup.moshi.Json

/**
 * created by RIZKI RACHMANUDIN on 17/07/2023
 */
data class DetailMovieImagesResponse(
    @field:Json(name = "backdrops") val backdrops: List<Backdrop>,
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "posters") val posters: List<Poster>
)
