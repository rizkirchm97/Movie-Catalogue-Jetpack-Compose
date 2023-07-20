package com.rizkir.data.mapper

import com.rizkir.data.model.dto.movie_images.Backdrop
import com.rizkir.data.model.dto.movie_images.DetailMovieImagesResponse
import com.rizkir.data.model.dto.movie_images.Poster
import com.rizkir.domain.entities.MovieImageEntity
import com.rizkir.domain.entities.Backdrop as BackdropEntity
import com.rizkir.domain.entities.Poster as PosterEntity

fun DetailMovieImagesResponse.mapToEntity() : MovieImageEntity {
    return MovieImageEntity(
        id = id,
        backdrops = backdrops.map { it.mapToEntity() },
        posters = posters.map { it.mapToEntity() }
    )
}

fun Backdrop.mapToEntity(): BackdropEntity {
    return BackdropEntity(
        aspect_ratio = aspect_ratio,
        file_path = file_path,
        height = height,
        iso_639_1 = iso_639_1,
        vote_average = vote_average,
        vote_count = vote_count,
        width = width
    )
}

fun Poster.mapToEntity(): PosterEntity {
    return PosterEntity(
        aspect_ratio = aspect_ratio,
        file_path = file_path,
        height = height,
        iso_639_1 = iso_639_1,
        vote_average = vote_average,
        vote_count = vote_count,
        width = width,
    )
}