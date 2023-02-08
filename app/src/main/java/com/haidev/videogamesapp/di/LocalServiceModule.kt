package com.haidev.videogamesapp.di

import android.app.Application
import androidx.room.Room
import com.haidev.videogamesapp.source.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalServiceModule {
    @Provides
    @Singleton
    fun provideLocalDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "app_db")
            .build()
}