package com.example.newsapp.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.model.NewsModel
import kotlinx.android.synthetic.main.news_list.view.*

class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(newsModel: NewsModel) {
        // Thumbnail
        Glide.with(itemView)
            .load(newsModel.thumbnail)
            .centerCrop()
            .into(itemView.news_img)

        // Title
        itemView.news_title.text = newsModel.title

        // Publisher
        itemView.news_publisher.text = newsModel.publisher.name

        // Open News
        itemView.setOnClickListener {
            if (itemView.context is ViewInterface) {
                (itemView.context as ViewInterface).openNews(newsModel.url)
            }
        }
    }
}