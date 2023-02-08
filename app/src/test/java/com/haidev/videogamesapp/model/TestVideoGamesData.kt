package com.haidev.videogamesapp.model

import com.haidev.videogamesapp.data.VideoGamesListResponse

object TestVideoGamesData {
    fun getVideoGamesData(): VideoGamesListResponse {
        return VideoGamesListResponse(
            listOf(
                VideoGamesListResponse.Result(
                    backgroundImage = "",
                    id = 0,
                    name = "GTA V",
                    released = "2022-12-30",
                    rating = 5.0,
                    added = 999
                )
            )
        )
    }
}
