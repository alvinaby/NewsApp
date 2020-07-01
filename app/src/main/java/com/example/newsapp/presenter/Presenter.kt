package com.example.newsapp.presenter

import android.content.Context
import com.example.newsapp.repository.LocalNewsRepo
import com.example.newsapp.repository.NewsRepo
import com.example.newsapp.repository.room.NewsDatabase
import com.example.newsapp.view.ViewInterface
import io.reactivex.disposables.Disposable

class Presenter(private val view: ViewInterface): PresenterInterface {
    private val newsRepo =  NewsRepo().getNews()
    private var disposable: Disposable? = null
    //private val localNewsRepo = LocalNewsRepo().getNewsDb()

    override fun loadNews() {
         disposable = newsRepo.subscribe(
                { view.onSuccess(it) },
                { view.onError() }
         )
    }

    override fun disposeNews() {
        disposable?.dispose()
    }
}
