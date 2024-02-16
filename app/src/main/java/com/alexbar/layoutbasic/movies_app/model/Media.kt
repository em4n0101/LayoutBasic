package com.alexbar.layoutbasic.movies_app.model

import android.annotation.SuppressLint
import com.alexbar.layoutbasic.movies_app.utils.MovieConstants
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat

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
) {
    fun getImagePosterCompleteUrl() = "${MovieConstants.base_url}$imagePosterUrl"
    fun getImageBackdropCompleteUrl() = "${MovieConstants.base_url}$imageBackdropUrl"
    fun getVoteAverageFormatted() = String.format("%.1f", voteAverage)

    @SuppressLint("SimpleDateFormat")
    fun getAirDateFormatted(): String {
        val originalFormat = SimpleDateFormat("yyyy-MM-dd")
        val newFormat = SimpleDateFormat("MMMM dd, yyyy")
        return originalFormat.parse(firstAirDate!!)?.let { newFormat.format(it) } ?: ""
    }

    @SuppressLint("SimpleDateFormat")
    fun getReleaseDateFormatted(): String {
        val originalFormat = SimpleDateFormat("yyyy-MM-dd")
        val newFormat = SimpleDateFormat("MMMM dd, yyyy")
        return originalFormat.parse(releaseDate!!)?.let { newFormat.format(it) } ?: ""
    }
}