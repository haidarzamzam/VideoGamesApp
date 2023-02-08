package com.haidev.videogamesapp.presenter

import androidx.lifecycle.ViewModel
import com.haidev.videogamesapp.contract.VideoGamesContract
import com.haidev.videogamesapp.model.VideoGamesModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*

class VideoGamesPresenter(
    private val videoGamesView: VideoGamesContract.VideoGamesView,
    private val videoGamesModel: VideoGamesModel,
    private val coroutineScope: CoroutineScope
) : ViewModel() {
    fun onAttach() {
        callVideoGamesApi()
    }

    private fun callVideoGamesApi() {
        videoGamesModel.callMoviesApi()
            .onStart {
                videoGamesView.showLoadingView()
            }
            .catch {
                videoGamesView.showErrorView(it)
            }
            .onEach {
                videoGamesView.showMoviesList(it)
            }
            .onCompletion {
                videoGamesView.hideLoadingView()
            }
            .launchIn(coroutineScope)
    }
}