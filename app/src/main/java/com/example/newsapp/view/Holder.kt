package com.example.newsapp.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.model.News
import kotlinx.android.synthetic.main.news_list.view.*

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(news: News) {
        // Thumbnail
        Glide.with(itemView)
            .load(news.thumbnail)
            .centerCrop()
            .into(itemView.news_img)

        // Title
        itemView.news_title.text = news.title

        // Publisher
        itemView.news_publisher.text = news.publisher.name

        // Open News
        itemView.setOnClickListener {
            (itemView.context as ViewInterface).openNews(news.url)
        }
    }
}