package com.haidev.videogamesapp.source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.haidev.videogamesapp.model.VideoGamesModel
import kotlinx.coroutines.flow.Flow

@Dao
interface VideoGamesDao {
    @Query("SELECT * FROM video_games_table")
    fun readAllVideoGames(): Flow<List<VideoGamesModel.Result>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllVideoGames(videoGames: List<VideoGamesModel.Result>?)

    @Query("DELETE FROM video_games_table")
    fun clearVideoGames()
}