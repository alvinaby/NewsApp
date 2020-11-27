package com.alvinaby.newsapp.view

import com.alvinaby.newsapp.model.News

interface ViewInterface {
    fun onSuccess(newsList: List<News>)
    fun onError()
    fun onNetworkChanged(isConnected: Boolean)
    fun openNews(url: String)
}