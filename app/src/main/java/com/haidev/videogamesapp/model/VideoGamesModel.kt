package com.haidev.videogamesapp.model

import com.haidev.videogamesapp.BuildConfig
import com.haidev.videogamesapp.data.VideoGamesListResponse
import com.haidev.videogamesapp.source.api.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class VideoGamesModel(private val apiService: ApiService) {
    fun callMoviesApi(): Flow<VideoGamesListResponse> {
        return flow {
            val carbonOffsetResponse =
                apiService.getVideoGameList(BuildConfig.API_KEY)
            emit(carbonOffsetResponse)
        }.flowOn(Dispatchers.IO)
    }
}