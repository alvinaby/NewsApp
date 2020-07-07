package com.example.newsapp.presenter

import com.example.newsapp.model.News
import com.example.newsapp.view.ViewInterface
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

class Presenter(
    private val view: ViewInterface,
    private val newsSource: Observable<List<News>>
): PresenterInterface {

    private var disposable: Disposable? = null

    override fun loadNews() {
         disposable = newsSource.subscribe(
             { view.onSuccess(it) },
             { view.onError() }
         )
    }

    override fun disposeNews() {
        disposable?.dispose()
    }
}
