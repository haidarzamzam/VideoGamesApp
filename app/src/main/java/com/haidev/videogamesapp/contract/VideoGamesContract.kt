package com.haidev.videogamesapp.contract

import com.haidev.videogamesapp.data.VideoGamesListResponse

interface VideoGamesContract {
    interface VideoGamesView {
        fun showVideoGamesList(videoGamesListResponse: VideoGamesListResponse)
        fun showErrorView()
        fun showLoadingView()
        fun hideLoadingView()
    }
}