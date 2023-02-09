package com.haidev.videogamesapp.contract

import com.haidev.videogamesapp.model.VideoGamesModel

interface VideoGamesContract {
    interface View {
        fun showVideoGamesList(videoGamesModel: List<VideoGamesModel.Result>)
        fun showErrorView()
        fun showLoadingView()
        fun hideLoadingView()
    }

    interface Presenter {
        fun onAttach()
    }
}