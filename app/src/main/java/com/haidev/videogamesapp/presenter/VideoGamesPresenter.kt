package com.haidev.videogamesapp.presenter

import com.haidev.videogamesapp.contract.VideoGamesContract
import com.haidev.videogamesapp.model.VideoGamesModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*

class VideoGamesPresenter(
    private val videoGamesView: VideoGamesContract.VideoGamesView,
    private val videoGamesModel: VideoGamesModel,
    private val coroutineScope: CoroutineScope
) {
    fun onAttach() {
        callVideoGamesApi()
    }

    private fun callVideoGamesApi() {
        videoGamesModel.callVideoGamesApi().onStart {
            videoGamesView.showLoadingView()
        }.catch {
            videoGamesView.showErrorView()
        }.onEach {
            videoGamesView.showVideoGamesList(it)
        }.onCompletion {
            videoGamesView.hideLoadingView()
        }.launchIn(coroutineScope)
    }
}