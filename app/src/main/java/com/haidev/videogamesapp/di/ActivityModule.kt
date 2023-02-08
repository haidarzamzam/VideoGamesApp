package com.haidev.videogamesapp.di

import android.app.Activity
import com.haidev.videogamesapp.view.VideoGamesActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
object ActivityModule {
    @Provides
    fun bindActivityVideoGames(activity: Activity): VideoGamesActivity {
        return activity as VideoGamesActivity
    }
}