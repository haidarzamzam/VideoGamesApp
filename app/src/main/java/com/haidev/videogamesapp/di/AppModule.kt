package com.haidev.videogamesapp.di

import android.app.Activity
import com.haidev.videogamesapp.contract.VideoGamesContract
import com.haidev.videogamesapp.presenter.VideoGamesPresenter
import com.haidev.videogamesapp.view.VideoGamesActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class AppModule {
    @Binds
    abstract fun bindActivityVideoGames(activity: VideoGamesActivity): VideoGamesContract.View

    @Binds
    abstract fun bindPresenterVideoGames(impl: VideoGamesPresenter): VideoGamesContract.Presenter
}

@InstallIn(ActivityComponent::class)
@Module
object ActivityModule {
    @Provides
    fun bindActivityVideoGames(activity: Activity): VideoGamesActivity {
        return activity as VideoGamesActivity
    }
}