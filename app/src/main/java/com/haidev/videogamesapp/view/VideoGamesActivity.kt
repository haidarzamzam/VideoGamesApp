package com.haidev.videogamesapp.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.haidev.videogamesapp.contract.VideoGamesContract
import com.haidev.videogamesapp.data.VideoGamesListResponse
import com.haidev.videogamesapp.databinding.ActivityVideoGamesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class VideoGamesActivity : AppCompatActivity(), VideoGamesContract.View {
    private lateinit var binding: ActivityVideoGamesBinding

    @Inject
    lateinit var presenter: VideoGamesContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoGamesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.onAttach()
    }

    override fun showVideoGamesList(videoGamesListResponse: VideoGamesListResponse) {
        Log.d("CHECKKKKSUCCESS", videoGamesListResponse.results.toString())
    }

    override fun showErrorView() {
    }

    override fun showLoadingView() {
        binding.pbLoading.visibility = View.VISIBLE
    }

    override fun hideLoadingView() {
        binding.pbLoading.visibility = View.GONE
    }
}