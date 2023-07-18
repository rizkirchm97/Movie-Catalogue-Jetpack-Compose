package com.rizkir.data.mapper

import com.rizkir.data.model.movie_discover.MovieDiscoverResult
import com.rizkir.domain.entities.MovieEntity

fun MovieDiscoverResult.mapToEntity(): MovieEntity {
    return MovieEntity(
        id = id,
        original_title = original_title,
        overview = overview,
        poster_path = poster_path,
        release_date = release_date,
        original_language = original_language
    )
}