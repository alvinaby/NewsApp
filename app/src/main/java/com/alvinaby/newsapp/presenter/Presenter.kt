package com.alvinaby.newsapp.presenter

import com.alvinaby.newsapp.repository.MainRepo
import com.alvinaby.newsapp.view.ViewInterface
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
