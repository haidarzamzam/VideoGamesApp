package com.haidev.videogamesapp.di

import com.haidev.videogamesapp.BuildConfig
import com.haidev.videogamesapp.source.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteServiceModule {
    @Singleton
    @Provides
    fun provideCacheInterceptor() = run {
        Interceptor { chain ->
            val response = chain.proceed(chain.request())
            val maxAge =
                60
            response.newBuilder()
                .header("Cache-Control", "public, max-age=$maxAge")
                .removeHeader("Pragma")
                .build()
        }
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor() = run {
        HttpLoggingInterceptor().apply {
            apply {
                if (BuildConfig.DEBUG) level = HttpLoggingInterceptor.Level.BODY
            }
        }
    }

    @Singleton
    @Provides
    fun provideApiBasic(
    ): ApiService {
        val client: OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(provideHttpLoggingInterceptor())
                .addInterceptor(provideCacheInterceptor())
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .build()


        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
