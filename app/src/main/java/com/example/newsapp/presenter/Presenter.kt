package com.example.newsapp.presenter

import com.example.newsapp.repository.NewsRepo
import com.example.newsapp.view.ViewInterface
import io.reactivex.disposables.Disposable

class Presenter(private val view: ViewInterface): PresenterInterface {
    private val newsRepo =  NewsRepo().getNews()
    private var disposable: Disposable? = null

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
