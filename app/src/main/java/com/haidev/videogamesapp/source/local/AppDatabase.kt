package com.haidev.videogamesapp.source.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.haidev.videogamesapp.data.VideoGamesListResponse
import com.haidev.videogamesapp.source.dao.VideoGamesDao

@Database(
    entities = [
        VideoGamesListResponse.Result::class
    ], version = 1, exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun videoGamesDao(): VideoGamesDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(
            application: Application
        ): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    "app_db"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}