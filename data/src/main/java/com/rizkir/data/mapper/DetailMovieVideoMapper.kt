package com.rizkir.data.mapper

import com.rizkir.data.model.dto.movie_videos.DetailMovieVideosResponse
import com.rizkir.data.model.dto.movie_videos.DetailMovieVideosResult
import com.rizkir.data.model.entity.MovieVideoEntity
import java.util.Random
import java.util.UUID
import com.rizkir.domain.entities.MovieVideoEntity as DomainMovieVideoEntity



fun DetailMovieVideosResult.mapToCachedEntity(movieID: Int): MovieVideoEntity {
    return MovieVideoEntity(
        idResult = id,
        id = movieID,
        key = key,
        name = name,
        site = site,
        type = type
    )
}


fun DetailMovieVideosResult.mapToDomainEntity(movieID: Int): DomainMovieVideoEntity.Result {
    return DomainMovieVideoEntity.Result(
        idResult = id,
        id = movieID,
        key = key,
        name = name,
        site = site,
        type = type
    )
}

fun MovieVideoEntity.mapToDomainEntity(): DomainMovieVideoEntity.Result {
    return DomainMovieVideoEntity.Result(
        idResult = idResult,
        id = id,
        key = key,
        name = name,
        site = site,
        type = type
    )
}

fun DomainMovieVideoEntity.Result.mapToDataEntity():  MovieVideoEntity{
    return  MovieVideoEntity(
        idResult = idResult,
        id = id,
        key = key,
        name = name,
        site = site,
        type = type
    )
}
