package com.haidev.videogamesapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VideoGamesListResponse(
    @SerializedName("results") val results: List<Result>?,
) : Parcelable {
    @Entity(tableName = "video_games_table")
    @Parcelize
    data class Result(
        @PrimaryKey @SerializedName("id") val id: Int,
        @SerializedName("background_image") val backgroundImage: String?,
        @SerializedName("name") val name: String?,
        @SerializedName("released") val released: String?,
        @SerializedName("rating") val rating: Double?,
        @SerializedName("added") val added: Int?,
    ) : Parcelable
}
