package com.haidev.videogamesapp.view

import android.os.Bundle
import android.view.View
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
        initUI()
    }

    private fun initUI() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.tvError.visibility = View.GONE
            presenter.onAttach()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    override fun showVideoGamesList(videoGamesModel: List<VideoGamesModel.Result>) {
        with(binding.rvVideoGames) {
            adapter = adapterVideoGames
            layoutManager = LinearLayoutManager(this@VideoGamesActivity)
            adapterVideoGames.updateVideoGamesItemsList(videoGamesModel)
        }
    }

    override fun showErrorView() {
        binding.pbLoading.visibility = View.GONE
        binding.tvError.visibility = View.VISIBLE
    }

    override fun showLoadingView() {
        binding.pbLoading.visibility = View.VISIBLE
    }

    override fun hideLoadingView() {
        binding.pbLoading.visibility = View.GONE
    }
}