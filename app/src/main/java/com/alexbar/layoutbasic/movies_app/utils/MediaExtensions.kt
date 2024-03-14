package com.alexbar.layoutbasic.movies_app.utils

import android.annotation.SuppressLint
import com.alexbar.layoutbasic.movies_app.model.Media
import java.text.ParseException
import java.text.SimpleDateFormat

fun Media.getImagePosterCompleteUrl() = "${MovieConstants.base_url}${this.imagePosterUrl}"
fun Media.getImageBackdropCompleteUrl() = "${MovieConstants.base_url}${this.imageBackdropUrl}"
fun Media.getVoteAverageFormatted() = String.format("%.1f", this.voteAverage)

@SuppressLint("SimpleDateFormat")
fun String?.formatDate(): String {
    if (this.isNullOrEmpty()) return ""
    val originalFormat = SimpleDateFormat("yyyy-MM-dd")
    val newFormat = SimpleDateFormat("MMMM dd, yyyy")
    return try {
        val date = originalFormat.parse(this)
        newFormat.format(date!!)
    } catch (e: ParseException) {
        ""
    }
}