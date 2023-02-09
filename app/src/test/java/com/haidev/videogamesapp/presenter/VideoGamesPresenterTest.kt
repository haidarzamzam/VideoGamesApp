package com.haidev.videogamesapp.presenter

import com.haidev.videogamesapp.TestVideoGamesData
import com.haidev.videogamesapp.contract.VideoGamesContract
import com.haidev.videogamesapp.repository.VideoGamesRepository
import com.haidev.videogamesapp.util.Resource
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
internal class VideoGamesPresenterTest {
    private val repository = mockk<VideoGamesRepository>(relaxed = true)

    private val view = mockk<VideoGamesContract.View>(relaxed = true)

    private lateinit var presenter: VideoGamesContract.Presenter

    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        presenter = VideoGamesPresenter(view, repository)
    }

    @Test
    fun testSuccessfulApiCall() = runTest {
        val response = Resource.Success(TestVideoGamesData.getVideoGamesData())
        coEvery { repository.getVideoGames() } returns flowOf(response)

        presenter.onAttach()

        verify { view.showLoadingView() }
        verify { view.hideLoadingView() }
        verify { view.showVideoGamesList(TestVideoGamesData.getVideoGamesData()) }
        verify(exactly = 0) { view.showErrorView() }
    }

    @Test
    fun testFailedApiCall() = runTest {
        val errorMessage = Throwable("error")
        every { repository.getVideoGames() } returns flowOf(Resource.Error(errorMessage))

        presenter.onAttach()

        verify { view.showLoadingView() }
        verify { view.hideLoadingView() }
        verify { view.showErrorView() }
        verify(exactly = 0) { view.showVideoGamesList(any()) }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}