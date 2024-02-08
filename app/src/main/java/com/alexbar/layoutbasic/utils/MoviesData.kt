package com.alexbar.layoutbasic.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.io.IOException

fun getJsonDataFromAsset(
    context: Context,
    fileName: String
): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
    } catch (exp: IOException) {
        exp.printStackTrace()
        return null
    }

    return jsonString
}

fun movieList(context: Context): MutableList<Movie> {
    val jsonFileString = getJsonDataFromAsset(context = context, "movies.json")
    val type = object : TypeToken<List<Movie>>() {}.type
    return Gson().fromJson(jsonFileString, type)
}

fun tvSeriesList(context: Context): MutableList<TVSeries> {
    val jsonFileString = getJsonDataFromAsset(context = context, "series.json")
    val type = object : TypeToken<List<TVSeries>>() {}.type
    return Gson().fromJson(jsonFileString, type)
}

sealed class Media
data class Movie(
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val description: String,
    @SerializedName("poster_path")
    val imageUrl: String,
    @SerializedName("first_air_date")
    val firstAirDate: String,
    @SerializedName("vote_average")
    val voteAverage: Double
) : Media()

data class TVSeries(
    @SerializedName("name")
    val name: String,
    @SerializedName("overview")
    val description: String,
    @SerializedName("poster_path")
    val imageUrl: String,
    @SerializedName("first_air_date")
    val firstAirDate: String,
    @SerializedName("vote_average")
    val voteAverage: Double
): Media()