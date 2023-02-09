package com.haidev.videogamesapp.repository

import androidx.room.withTransaction
import com.haidev.videogamesapp.BuildConfig
import com.haidev.videogamesapp.source.api.ApiService
import com.haidev.videogamesapp.source.local.AppDatabase
import com.haidev.videogamesapp.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class VideoGamesRepository @Inject constructor(
    private val apiService: ApiService,
    private val dbService: AppDatabase
) {

    private val videoGamesDao = dbService.videoGamesDao()

    fun getVideoGames() = networkBoundResource(
        query = {
            videoGamesDao.readAllVideoGames()
        },
        fetch = {
            delay(2000)
            apiService.getVideoGameList(BuildConfig.API_KEY)
        },
        saveFetchResult = { videoGames ->
            dbService.withTransaction {
                videoGamesDao.clearVideoGames()
                videoGamesDao.addAllVideoGames(videoGames.results)
            }
        },
        shouldFetch = { videoGames ->
            videoGames.isEmpty()
        }
    )
}