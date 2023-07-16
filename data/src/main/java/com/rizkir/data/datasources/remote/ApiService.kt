package com.rizkir.data.datasources.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path


interface ApiService {
    @GET("/discover/movie")
    suspend fun fetchDiscoverMovie(): Response<String>

    @GET("/movie/{movie_id}")
    suspend fun getDetailMovie(
        @Path("movie_id") movieId: String
    )

    @GET("/movie/{movie_id}/images")
    suspend fun getDetailMovieImages(
        @Path("movie_id") movieId: String
    )

    @GET("/movie/{movie_id}/videos")
    suspend fun getDetailMovieVideos(
        @Path("movie_id") movieId: String
    )
}