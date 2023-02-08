package com.haidev.videogamesapp.di

import com.haidev.videogamesapp.contract.VideoGamesContract
import com.haidev.videogamesapp.presenter.VideoGamesPresenter
import com.haidev.videogamesapp.view.VideoGamesActivity
import dagger.Binds
import dagger.Module
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


