package com.example.newsapp.presenter

import com.example.newsapp.repository.NewsRepo
import com.example.newsapp.view.ViewInterface
import io.reactivex.disposables.Disposable

class Presenter(
    private val view: ViewInterface,
    private val newsRepo: NewsRepo
): PresenterInterface {

    private var disposable: Disposable? = null

    override fun loadNews() {
         disposable = newsRepo.getNewsRemote().subscribe(
             { view.onSuccess(it) },
             { view.onError() }
         )
    }

    override fun disposeNews() {
        disposable?.dispose()
    }
}
