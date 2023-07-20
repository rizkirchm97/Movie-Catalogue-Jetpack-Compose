package com.rizkir.data.datasources.remote

import com.rizkir.data.model.dto.movie_detail.MovieDetailResponse
import com.rizkir.data.model.dto.movie_discover.MovieDiscoverResponse
import com.rizkir.data.model.dto.movie_images.DetailMovieImagesResponse
import com.rizkir.data.model.dto.movie_reviews.ReviewResponse
import com.rizkir.data.model.dto.movie_videos.DetailMovieVideosResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
    @GET("discover/movie")
    suspend fun fetchDiscoverMovie(@Query("page") page: Int): Response<MovieDiscoverResponse>

    @GET("movie/{movie_id}")
    suspend fun getDetailMovie(
        @Path("movie_id") movieId: Int
    ) : Response<MovieDetailResponse>

    @GET("movie/{movie_id}/images")
    suspend fun getDetailMovieImages(
        @Path("movie_id") movieId: Int
    ) : Response<DetailMovieImagesResponse>

    @GET("movie/{movie_id}/videos")
    suspend fun getDetailMovieVideos(
        @Path("movie_id") movieId: Int
    ) : Response<DetailMovieVideosResponse>

    @GET("movie/{movie_id}/reviews")
    suspend fun getMovieReview(
        @Path("movie_id") movieId: Int
    ) : Response<ReviewResponse>
}