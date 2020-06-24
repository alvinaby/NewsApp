package com.example.newsapp.presenter

import com.example.newsapp.api.ApiService
import com.example.newsapp.view.ViewInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class Presenter(private val view: ViewInterface): PresenterInterface {
    private val apiGetNews = ApiService().retrofit().getNews()
    private val compositeDisposable = CompositeDisposable()

    override fun getNews() {
        compositeDisposable.add(apiGetNews
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> view.onSuccess(result) },
                { view.onError() }
            )
        )
    }
}
