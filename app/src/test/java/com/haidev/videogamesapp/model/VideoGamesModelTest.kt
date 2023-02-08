package com.haidev.videogamesapp.model

import com.haidev.videogamesapp.BuildConfig
import com.haidev.videogamesapp.source.api.ApiService
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.whenever
import javax.inject.Inject

@HiltAndroidTest
internal class VideoGamesModelTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var model: VideoGamesModel

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun `Scenario Api Success`() = runBlocking {
        whenever(apiService.getVideoGameList(BuildConfig.API_KEY)).thenReturn(TestVideoGamesData.getVideoGamesData())
        model.getVideoGames().collect {
            assertEquals(TestVideoGamesData.getVideoGamesData(), it)
        }
    }

    @Test
    fun `Scenario Api Failure`() = runBlocking {
        val error = NullPointerException("null pointer")
        whenever(apiService.getVideoGameList(BuildConfig.API_KEY)).thenThrow(error)
        model.getVideoGames().catch {
            assertEquals("null pointer", it.message)
        }.collect { assertNull(it) }
    }
}
