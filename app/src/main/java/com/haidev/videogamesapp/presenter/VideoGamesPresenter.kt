package com.haidev.videogamesapp.presenter

import com.haidev.videogamesapp.contract.VideoGamesContract
import com.haidev.videogamesapp.model.VideoGamesModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class VideoGamesPresenter @Inject constructor(
    private val videoGamesView: VideoGamesContract.View,
    private val videoGamesModel: VideoGamesModel,
    private val coroutineScope: CoroutineScope
) : VideoGamesContract.Presenter {
    override fun onAttach() {
        callVideoGamesApi()
    }

    private fun callVideoGamesApi() {
        videoGamesModel.callVideoGamesApi().onStart {
            videoGamesView.showLoadingView()
        }
            .catch {
                videoGamesView.showErrorView()
            }
            .onEach {
                videoGamesView.showVideoGamesList(it)
            }
            .onCompletion {
                videoGamesView.hideLoadingView()
            }
            .launchIn(coroutineScope)
    }
}