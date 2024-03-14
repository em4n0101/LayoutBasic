package com.alexbar.layoutbasic.movies_app.networking

import com.alexbar.layoutbasic.movies_app.utils.MovieConstants.api_base_url
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants.user_token
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val tokenInterceptor = Interceptor { chain ->
        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $user_token")
            .build()
        chain.proceed(newRequest)
    }
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .addInterceptor(tokenInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(api_base_url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val mediaService: ServiceInterface = retrofit.create(ServiceInterface::class.java)
}
