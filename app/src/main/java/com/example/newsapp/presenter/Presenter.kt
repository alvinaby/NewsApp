package com.example.newsapp.presenter

import com.example.newsapp.api.ApiService
import com.example.newsapp.view.ViewInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class Presenter(private val view: ViewInterface): PresenterInterface {
    private var disposable: Disposable? = null
    private val apiGetNews = ApiService().retrofit().getNews()

    override fun getNews() {
        disposable = apiGetNews
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{ result -> view.showNews(result) }
    }
}
