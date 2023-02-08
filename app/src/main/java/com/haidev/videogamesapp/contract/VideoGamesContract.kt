package com.haidev.videogamesapp.contract

import com.haidev.videogamesapp.data.VideoGamesListResponse

interface VideoGamesContract {
    interface View {
        fun showVideoGamesList(videoGamesListResponse: List<VideoGamesListResponse.Result>)
        fun showErrorView()
        fun showLoadingView()
        fun hideLoadingView()
    }

    interface Presenter {
        fun onAttach()
    }
}