package com.alexbar.layoutbasic.movies_app.model

import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("overview")
    val description: String,
    @SerializedName("poster_path")
    val imagePosterUrl: String,
    @SerializedName("backdrop_path")
    val imageBackdropUrl: String,
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("first_air_date")
    val firstAirDate: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("vote_average")
    val voteAverage: Double
)