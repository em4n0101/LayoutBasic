package com.alexbar.layoutbasic.movies_app.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

inline fun <reified T> Context.getListFromJsonAsset(fileName: String): List<T>? {
    val jsonFileString: String
    try {
        jsonFileString = assets.open(fileName).bufferedReader().use {
            it.readText()
        }
    } catch (exp: IOException) {
        exp.printStackTrace()
        return null
    }

    val type = object : TypeToken<List<T>>() {}.type
    return Gson().fromJson(jsonFileString, type)
}
