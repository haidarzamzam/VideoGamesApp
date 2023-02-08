package com.haidev.videogamesapp

import android.app.Application
import android.content.Context
import com.haidev.videogamesapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {
    init {
        instance = this
    }

    companion object {
        private var instance: MyApp? = null
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(
                listOf(
                    viewModule,
                    contractModule,
                    presenterModule,
                    modelModule,
                    remoteModule
                )
            )
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }
}