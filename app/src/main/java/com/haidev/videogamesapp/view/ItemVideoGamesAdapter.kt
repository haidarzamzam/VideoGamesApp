package com.haidev.videogamesapp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.haidev.videogamesapp.databinding.ItemRowVideoGamesBinding
import com.haidev.videogamesapp.model.VideoGamesModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ItemVideoGamesAdapter @Inject constructor(@ApplicationContext private val context: Context) :
    RecyclerView.Adapter<VideoGamesItemsViewHolder>() {

    private val videoGamesList = mutableListOf<VideoGamesModel.Result>()
    internal fun updateVideoGamesItemsList(itemsResponse: List<VideoGamesModel.Result>?) {
        videoGamesList.clear()
        itemsResponse?.let { videoGamesList.addAll(it) }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoGamesItemsViewHolder {
        val binding = ItemRowVideoGamesBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoGamesItemsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoGamesItemsViewHolder, position: Int) {
        holder.bindDetails(videoGamesList[position], context)
    }

    override fun getItemCount(): Int {
        return videoGamesList.size
    }
}

class VideoGamesItemsViewHolder(@NonNull val binding: ItemRowVideoGamesBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindDetails(
        videoGamesModel: VideoGamesModel.Result,
        context: Context
    ) {
        with(binding) {
            tvTitleVideoGame.text = videoGamesModel.name
            tvReleaseDateVideoGame.text = videoGamesModel.released
            tvRatingVideoGame.text = videoGamesModel.rating.toString()
            tvAddedVideoGame.text = videoGamesModel.added.toString()
            Glide.with(context).load(videoGamesModel.backgroundImage).into(ivVideoGame)
        }
    }
}
