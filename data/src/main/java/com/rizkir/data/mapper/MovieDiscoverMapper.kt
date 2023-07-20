package com.rizkir.data.mapper

import com.rizkir.data.model.dto.movie_discover.MovieDiscoverResponse
import com.rizkir.data.model.dto.movie_discover.MovieDiscoverResult
import com.rizkir.data.model.entity.DiscoverMovieCacheEntity
import com.rizkir.domain.entities.MovieEntity

//fun MovieDiscoverResponse.MoviesResult.mapToEntity(): MovieEntity {
//    return MovieEntity(
//        id = id,
//        original_title = original_title,
//        overview = overview,
//        poster_path = poster_path,
//        release_date = release_date,
//        original_language = original_language
//    )
//}

fun MovieDiscoverResult.mapToCachedEntity2(page: Int): DiscoverMovieCacheEntity {
    return DiscoverMovieCacheEntity(
        adult = adult,
        backdropPath = backdrop_path ?: "",
        genreIds = if (genre_ids?.isNotEmpty() == true) genre_ids.toString() else "",
        id = id,
        title = title ?: "",
        video = video,
        popularity = popularity ?: "" ,
        overview = overview ?: "",
        originalLanguage = original_language ?: "",
        originalTitle = original_title ?: "",
        posterPath = poster_path ?: "",
        releaseDate = release_date ?: "",
        voteAverage = vote_average ?: "",
        voteCount = vote_count ?: 0,
        page = page
    )
}

//fun MovieDiscoverResponse.MoviesResult.mapToCachedEntity(page: Int): DiscoverMovieCacheEntity {
//    return DiscoverMovieCacheEntity(
//        adult = adult,
//        backdropPath = backdrop_path,
//        genreIds = if (genre_ids.isNotEmpty()) genre_ids.toString() else "",
//        id = id,
//        title = title,
//        video = video,
//        popularity = popularity,
//        overview = overview,
//        originalLanguage = original_language,
//        originalTitle = original_title,
//        posterPath = poster_path,
//        releaseDate = release_date,
//        voteAverage = vote_average,
//        voteCount = vote_count,
//        page = page
//    )
//}


fun DiscoverMovieCacheEntity.mapToEntity(): MovieEntity {
    return MovieEntity(
        id = id,
        original_title = originalTitle ?: "",
        overview = overview ?: "",
        poster_path = posterPath ?: "",
        release_date = releaseDate ?: "",
        original_language = originalLanguage ?: ""

    )
}