package com.alexbar.layoutbasic.movies_app.model

import com.google.gson.annotations.SerializedName

data class MediaResponse(
    @SerializedName("results") val results: List<Media>
)

