package com.example.newsapp.presenter

import com.example.newsapp.api.ApiService
import com.example.newsapp.view.ViewInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class Presenter(private val view: ViewInterface): PresenterInterface {
    private val apiClient = ApiService().retrofit()
    private var compositeDisposable = CompositeDisposable()

    override fun getNews() {
        compositeDisposable.add(apiClient.getNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> view.onSuccess(result) },
                { view.onError() }
            )
        )
    }

    override fun disposeNews() {
        compositeDisposable.dispose()
    }
}
