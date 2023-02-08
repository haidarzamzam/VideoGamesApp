package com.haidev.videogamesapp.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.haidev.videogamesapp.contract.VideoGamesContract
import com.haidev.videogamesapp.data.VideoGamesListResponse
import com.haidev.videogamesapp.databinding.ActivityVideoGamesBinding
import com.haidev.videogamesapp.presenter.VideoGamesPresenter
import org.koin.android.ext.android.inject

class VideoGamesActivity : AppCompatActivity(), VideoGamesContract.VideoGamesView {
    private lateinit var activityVideoGamesBinding: ActivityVideoGamesBinding
    private val videoGamesPresenter: VideoGamesPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityVideoGamesBinding = ActivityVideoGamesBinding.inflate(layoutInflater)
        setContentView(activityVideoGamesBinding.root)

        videoGamesPresenter.onAttach()
    }

    override fun showMoviesList(videoGamesListResponse: VideoGamesListResponse) {
        Log.d("CHECKKKKSUCCESS", videoGamesListResponse.results.toString())
    }

    override fun showErrorView(throwable: Throwable) {
        Log.d("CHECKKKKERROR", throwable.message.toString())
    }

    override fun showLoadingView() {
        Log.d("CHECKKKKSHOWLOAD", "LOADINGSHOW")
    }

    override fun hideLoadingView() {
        Log.d("CHECKKKKHIDELOAD", "LOADINGHIDE")
    }
}