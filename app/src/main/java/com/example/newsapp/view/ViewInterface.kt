package com.example.newsapp.view

import com.example.newsapp.model.News

interface ViewInterface {
    fun showNews(newsList: List<News>)
    fun openNews(url: String)
}