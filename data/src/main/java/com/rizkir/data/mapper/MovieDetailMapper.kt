package com.rizkir.data.mapper

import com.rizkir.data.model.movie_detail.MovieDetailResponse
import com.rizkir.domain.entities.DetailMovieEntity

fun MovieDetailResponse.mapToEntity() : DetailMovieEntity {
    return DetailMovieEntity(
        adult = adult,
        backdrop_path = backdrop_path,
        imdb_id = imdb_id,
        id = id,
        budget = budget,
        homepage = homepage,
        original_language = original_language,
        original_title = original_title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        release_date = release_date,
        revenue = revenue,
        runtime = runtime,
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        vote_average = vote_average,
        vote_count = vote_count
    )
}