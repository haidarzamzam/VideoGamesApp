package com.haidev.videogamesapp.source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.haidev.videogamesapp.data.VideoGamesListResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface VideoGamesDao {
    @Query("SELECT * FROM video_games_table")
    fun readAllVideoGames(): Flow<List<VideoGamesListResponse.Result>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllVideoGames(videoGames: List<VideoGamesListResponse.Result>?)

    @Query("DELETE FROM video_games_table")
    fun clearVideoGames()
}