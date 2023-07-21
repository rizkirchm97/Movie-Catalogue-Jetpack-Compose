package com.rizkir.data.mapper

import com.rizkir.data.model.dto.movie_detail.MovieDetailResponse
import com.rizkir.data.model.entity.MovieDetailEntity
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
        vote_count = vote_count,
        genre = genres.joinToString { it.name }
    )
}

fun MovieDetailResponse.mapToCachedEntity(): MovieDetailEntity {
    return MovieDetailEntity(
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
        vote_count = vote_count,
        genres = genres.toString(),
    )
}


fun MovieDetailEntity.mapToDomainEntity(): DetailMovieEntity {
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
        vote_count = vote_count,
        genre = genres
    )
}

fun DetailMovieEntity.mapToDataEntity(): MovieDetailEntity {
    return MovieDetailEntity(
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
        genres = genre,
        vote_count = vote_count,
    )
}