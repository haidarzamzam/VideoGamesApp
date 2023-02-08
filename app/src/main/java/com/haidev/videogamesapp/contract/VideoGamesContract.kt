package com.haidev.videogamesapp.contract

import com.haidev.videogamesapp.data.VideoGamesListResponse

interface VideoGamesContract {
    interface VideoGamesView {
        fun showMoviesList(videoGamesListResponse: VideoGamesListResponse)
        fun showErrorView(throwable: Throwable)
        fun showLoadingView()
        fun hideLoadingView()
    }
}