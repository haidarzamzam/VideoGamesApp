package com.haidev.videogamesapp.presenter

import com.haidev.videogamesapp.contract.VideoGamesContract
import com.haidev.videogamesapp.repository.VideoGamesRepository
import com.haidev.videogamesapp.util.Resource
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.plus
import javax.inject.Inject

class VideoGamesPresenter @Inject constructor(
    private val videoGamesView: VideoGamesContract.View,
    private val videoGamesRepository: VideoGamesRepository
) : VideoGamesContract.Presenter {
    override fun onAttach() {
        callVideoGamesApi()
    }

    private fun callVideoGamesApi() {
        videoGamesRepository.getVideoGames()
            .onStart {
                videoGamesView.showLoadingView()
            }.catch {
                videoGamesView.showErrorView()
            }.onEach { resource ->
                when (resource) {
                    is Resource.Error -> {
                        videoGamesView.showErrorView()
                    }
                    is Resource.Loading -> {
                        videoGamesView.showLoadingView()
                    }
                    is Resource.Success -> {
                        videoGamesView.hideLoadingView()

                    }
                }
                resource.data?.let { data -> videoGamesView.showVideoGamesList(data) }
            }.onCompletion {
                videoGamesView.hideLoadingView()
            }.launchIn(MainScope() + CoroutineName("VideoGamesCoroutine"))
    }
}