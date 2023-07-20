package com.rizkir.data.mapper

import com.rizkir.data.model.dto.movie_videos.DetailMovieVideosResponse
import com.rizkir.domain.entities.MovieVideoEntity

fun DetailMovieVideosResponse.mapToEntity() : MovieVideoEntity {
    return MovieVideoEntity(
        id = id,
        results = if (results.isNotEmpty()) {
            listOf(
                MovieVideoEntity.Result(
                    id = results[0].id,
                    name = results[0].name,
                    type = results[0].type,
                    iso_639_1 = results[0].iso_639_1,
                    iso_3166_1 = results[0].iso_3166_1,
                    key = results[0].key,
                    site = results[0].site,
                    size = results[0].size
                )
            )
        } else {
            emptyList()
        }

    )
}