package com.alvinaby.newsapp.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.alvinaby.newsapp.model.News
import kotlinx.android.synthetic.main.news_list.view.*

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(news: News) {
        // Thumbnail
        Glide.with(itemView)
            .load(news.thumbnail)
            .centerCrop()
            .into(itemView.newsThumbnail)

        // Title
        itemView.newsTitle.text = news.title

        // Publisher
        itemView.newsPublisher.text = news.publisher?.name ?: "-- Offline --"

        // Open News
        itemView.setOnClickListener {
            news.url?.let { (itemView.context as ViewInterface).openNews(it) }
        }
    }
}