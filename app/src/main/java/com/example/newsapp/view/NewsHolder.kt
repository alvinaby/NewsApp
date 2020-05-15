package com.example.newsapp.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.model.NewsModel
import kotlinx.android.synthetic.main.news_list.view.*

class NewsHolder(newsView: View): RecyclerView.ViewHolder(newsView){
    fun bind(newsItem: NewsModel) {
        // Thumbnail
        Glide.with(itemView)
            .load(newsItem.thumbnail)
            .centerCrop()
            .into(itemView.news_img)

        // Title
        itemView.news_title.text = newsItem.title

        // Publisher
        itemView.news_publisher.text = newsItem.publisher.name

        // Open News
        itemView.setOnClickListener {
            if (itemView.context is ViewInterface) {
                (itemView.context as ViewInterface).openNews(newsItem.url)
            }
        }
    }
}