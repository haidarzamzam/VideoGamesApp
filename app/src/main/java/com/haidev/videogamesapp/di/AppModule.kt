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
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.plus
import javax.inject.Singleton

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

@Module
@InstallIn(SingletonComponent::class)
object CoroutineModule {
    @Provides
    @Singleton
    fun provideCoroutineScope(
    ): CoroutineScope {
        return MainScope() + CoroutineName("VideoGamesCoroutine")
    }
}