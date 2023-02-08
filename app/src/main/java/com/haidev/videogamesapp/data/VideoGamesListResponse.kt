package com.haidev.videogamesapp.data

import com.google.gson.annotations.SerializedName

data class VideoGamesListResponse(
    @SerializedName("results") val results: List<Result>?,
) {
    data class Result(
        @SerializedName("id") val id: Int?,
        @SerializedName("background_image") val backgroundImage: String?,
        @SerializedName("name") val name: String?,
        @SerializedName("released") val released: String?,
        @SerializedName("rating") val rating: Double?,
        @SerializedName("added") val added: Int?,
    )
}
