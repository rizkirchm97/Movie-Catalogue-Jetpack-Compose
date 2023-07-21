package com.rizkir.data.mapper

import com.rizkir.data.model.dto.movie_detail.MovieDetailResponse
import com.rizkir.data.model.dto.movie_reviews.ReviewResponse
import com.rizkir.data.model.dto.movie_reviews.ReviewResult
import com.rizkir.data.model.entity.MovieReviewsEntity
import com.rizkir.domain.entities.MovieReviewEntity


fun ReviewResult.mapToCachedEntity(movieId: Int, avatarPath: String): MovieReviewsEntity {
    return MovieReviewsEntity(
        idReview = id,
        id = movieId,
        author = author,
        avatarPath = avatarPath,
        content = content,
        url = url
    )
}

fun ReviewResult.mapToDomainEntity(movieId: Int, avatarPath: String?): MovieReviewEntity {
    return MovieReviewEntity(
        idReview = id,
        id = movieId,
        author = author,
        avatarPath = avatarPath,
        content = content,
        url = url
    )
}

fun MovieReviewsEntity.mapToDomainEntity(): MovieReviewEntity {
    return MovieReviewEntity(
        idReview = idReview,
        id = id,
        author = author,
        avatarPath = avatarPath,
        content = content,
        url = url
    )
}

fun MovieReviewEntity.mapToDataEntity(): MovieReviewsEntity {
    return MovieReviewsEntity(
        idReview = idReview,
        id = id,
        author = author ?: "",
        avatarPath = avatarPath ?: "",
        content = content ?: "",
        url = url ?: ""
    )
}
