package com.example.newsapp.presenter

import com.example.newsapp.repository.MainRepo
import com.example.newsapp.view.ViewInterface
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class Presenter @Inject constructor (
    private val view: ViewInterface,
    private val mainRepo: MainRepo
) : PresenterInterface {

    private var disposable: Disposable? = null

    override fun loadNews() {
         disposable = mainRepo.getNews().subscribe(
             { view.onSuccess(it) },
             { view.onError() }
         )
    }

    override fun disposeNews() {
        disposable?.dispose()
    }

}
