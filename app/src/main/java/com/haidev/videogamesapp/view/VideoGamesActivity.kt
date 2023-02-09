package com.haidev.videogamesapp.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.haidev.videogamesapp.contract.VideoGamesContract
import com.haidev.videogamesapp.databinding.ActivityVideoGamesBinding
import com.haidev.videogamesapp.model.VideoGamesModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class VideoGamesActivity : AppCompatActivity(), VideoGamesContract.View {
    private lateinit var binding: ActivityVideoGamesBinding

    @Inject
    lateinit var presenter: VideoGamesContract.Presenter

    @Inject
    lateinit var adapterVideoGames: ItemVideoGamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoGamesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.onAttach()
    }

    override fun showVideoGamesList(videoGamesModel: List<VideoGamesModel.Result>) {
        binding.pbLoading.visibility = View.GONE
        with(binding.rvVideoGames) {
            adapter = adapterVideoGames
            layoutManager = LinearLayoutManager(this@VideoGamesActivity)
            adapterVideoGames.updateVideoGamesItemsList(videoGamesModel)
        }
    }

    override fun showErrorView() {
        binding.pbLoading.visibility = View.GONE
        Toast.makeText(this, "Sorry, the request failed, please try again later", Toast.LENGTH_LONG)
            .show()
    }

    override fun showLoadingView() {
        binding.pbLoading.visibility = View.VISIBLE
    }

    override fun hideLoadingView() {
        binding.pbLoading.visibility = View.GONE
    }
}