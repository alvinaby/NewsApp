package com.example.newsapp.view

import com.example.newsapp.model.NewsModel

interface ViewInterface {
    fun showNews(newsList: List<NewsModel>)
    fun openNews(url: String)
}