package com.example.newsapp.presenter

import com.example.newsapp.repository.NewsRepo
import com.example.newsapp.view.ViewInterface
import io.reactivex.disposables.CompositeDisposable

class Presenter(private val view: ViewInterface): PresenterInterface {
    private val newsRepo =  NewsRepo().getNews()
    private var compositeDisposable = CompositeDisposable()

    override fun loadNews() {
        compositeDisposable.add(
            newsRepo.subscribe(
                { view.onSuccess(it) },
                { view.onError() }
            )
        )
    }

    override fun disposeNews() {
        compositeDisposable.dispose()
    }
}
