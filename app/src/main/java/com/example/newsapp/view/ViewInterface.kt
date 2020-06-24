package com.example.newsapp.view

import com.example.newsapp.model.News

interface ViewInterface {
    fun onSuccess(newsList: List<News>)
    fun onError()
    fun openNews(url: String)
}