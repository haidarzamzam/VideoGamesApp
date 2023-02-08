package com.haidev.videogamesapp.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.haidev.videogamesapp.contract.VideoGamesContract
import com.haidev.videogamesapp.data.VideoGamesListResponse
import com.haidev.videogamesapp.databinding.ActivityVideoGamesBinding

class VideoGamesActivity : AppCompatActivity(), VideoGamesContract.VideoGamesView {
    private lateinit var activityVideoGamesBinding: ActivityVideoGamesBinding
    //private val videoGamesPresenter: VideoGamesPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityVideoGamesBinding.root)

        //videoGamesPresenter.onAttach()
    }


    override fun showVideoGamesList(videoGamesListResponse: VideoGamesListResponse) {
        Log.d("CHECKKKKSUCCESS", videoGamesListResponse.results.toString())
    }

    override fun showErrorView() {
    }

    override fun showLoadingView() {
        activityVideoGamesBinding.pbLoading.visibility = View.VISIBLE
    }

    override fun hideLoadingView() {
        activityVideoGamesBinding.pbLoading.visibility = View.GONE
    }
}