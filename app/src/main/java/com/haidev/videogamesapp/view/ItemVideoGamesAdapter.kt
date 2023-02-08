package com.haidev.videogamesapp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.haidev.videogamesapp.data.VideoGamesListResponse
import com.haidev.videogamesapp.databinding.ItemRowVideoGamesBinding
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ItemVideoGamesAdapter @Inject constructor(@ApplicationContext private val context: Context) :
    RecyclerView.Adapter<VideoGamesItemsViewHolder>() {

    private val videoGamesList = mutableListOf<VideoGamesListResponse.Result>()
    internal fun updateVideoGamesItemsList(itemsResponse: List<VideoGamesListResponse.Result>?) {
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
        videoGamesListResponse: VideoGamesListResponse.Result,
        context: Context
    ) {
        with(binding) {
            tvTitleVideoGame.text = videoGamesListResponse.name
            tvReleaseDateVideoGame.text = videoGamesListResponse.released
            tvRatingVideoGame.text = videoGamesListResponse.rating.toString()
            tvAddedVideoGame.text = videoGamesListResponse.added.toString()
            Glide.with(context).load(videoGamesListResponse.backgroundImage).into(ivVideoGame)
        }
    }
}
