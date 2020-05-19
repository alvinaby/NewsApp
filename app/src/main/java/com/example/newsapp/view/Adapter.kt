package com.example.newsapp.view

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.newsapp.model.News
import com.example.newsapp.R

class Adapter(private val newsItem: List<News>): RecyclerView.Adapter<Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.news_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(newsItem[position])
    }

    override fun getItemCount(): Int = newsItem.size
}