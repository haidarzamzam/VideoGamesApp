package com.haidev.videogamesapp

import com.haidev.videogamesapp.model.VideoGamesModel

object TestVideoGamesData {
    fun getVideoGamesData(): List<VideoGamesModel.Result> {
        return listOf(
            VideoGamesModel.Result(
                backgroundImage = "",
                id = 0,
                name = "GTA V",
                released = "2022-12-30",
                rating = 5.0,
                added = 999
            )
        )
    }
}
