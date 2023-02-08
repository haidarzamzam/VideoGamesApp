package com.haidev.videogamesapp.di

import com.haidev.videogamesapp.BuildConfig
import com.haidev.videogamesapp.source.remote.provideApiBasic
import com.haidev.videogamesapp.source.remote.provideCacheInterceptor
import com.haidev.videogamesapp.source.remote.provideHttpLoggingInterceptor
import com.haidev.videogamesapp.source.remote.provideMoshiConverter
import org.koin.dsl.module

val remoteModule = module {
    single { provideCacheInterceptor() }
    single { provideHttpLoggingInterceptor() }
    single { provideMoshiConverter() }
    single {
        provideApiBasic(
            BuildConfig.API_URL,
            get()
        )
    }
}
