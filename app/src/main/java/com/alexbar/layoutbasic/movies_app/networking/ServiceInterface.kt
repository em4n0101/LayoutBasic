package com.alexbar.layoutbasic.movies_app.networking

import com.alexbar.layoutbasic.movies_app.model.MediaResponse
import retrofit2.Response
import retrofit2.http.GET

interface ServiceInterface {
    @GET("trending/movie/day")
    suspend fun getTrendingMovies(): Response<MediaResponse>

    @GET("trending/tv/day")
    suspend fun getTrendingSeries(): Response<MediaResponse>
}
