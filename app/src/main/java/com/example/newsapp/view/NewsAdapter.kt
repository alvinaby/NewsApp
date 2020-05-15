package com.example.newsapp.view

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.newsapp.model.NewsModel
import com.example.newsapp.R

class NewsAdapter(private val newsItem: List<NewsModel>): RecyclerView.Adapter<NewsHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): NewsHolder {
        return NewsHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.news_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.bind(newsItem[position])
    }

    override fun getItemCount() = newsItem.size
}