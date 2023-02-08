package com.haidev.videogamesapp.di

import com.haidev.videogamesapp.contract.VideoGamesContract
import com.haidev.videogamesapp.databinding.ActivityVideoGamesBinding
import com.haidev.videogamesapp.model.VideoGamesModel
import com.haidev.videogamesapp.presenter.VideoGamesPresenter
import com.haidev.videogamesapp.view.VideoGamesActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val viewModule = module {
    scope<VideoGamesActivity> {
        scoped { ActivityVideoGamesBinding.bind(get()) }
    }
}

val contractModule = module {
    single<VideoGamesContract.VideoGamesView> { VideoGamesActivity() }
}

val presenterModule = module {
    single { VideoGamesPresenter(get(), get(), get()) }
    factory { CoroutineScope(Dispatchers.IO) }
}

val modelModule = module {
    single { VideoGamesModel(get()) }
}