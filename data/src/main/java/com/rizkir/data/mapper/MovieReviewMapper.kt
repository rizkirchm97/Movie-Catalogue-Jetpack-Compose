package com.rizkir.data.mapper

import com.rizkir.data.model.dto.movie_reviews.ReviewResponse
import com.rizkir.domain.entities.MovieReviewEntity

fun ReviewResponse.mapToEntity() : MovieReviewEntity {
    return MovieReviewEntity(
        id = id,
        page = page,
        total_pages = total_pages,
        total_results = total_results,
        results = if (results.isNotEmpty()) {
            listOf(
                MovieReviewEntity.Result(
                    id = results[0].id,
                    author = results[0].author,
                    author_details = MovieReviewEntity.Result.AuthorDetails(
                        name = results[0].author_details.name,
                        avatar_path = results[0].author_details.avatar_path,
                        rating = results[0].author_details.rating,
                        username = results[0].author_details.username,
                    ),
                    content = results[0].content,
                    url = results[0].url

                )
            )
        } else {
            emptyList()
        }
    )
}