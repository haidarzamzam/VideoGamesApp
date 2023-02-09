package com.haidev.videogamesapp.source.api

import com.haidev.videogamesapp.model.VideoGamesModel
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("games")
    suspend fun getVideoGameList(
        @Query("key") key: String
    ): VideoGamesModel
}