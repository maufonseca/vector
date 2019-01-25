package com.example.vector.presentation.main

import com.example.vector.infrastructure.NumbersService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ResultInteractor(private val resultPresenter: ResultPresentation): ResultInteraction {

    override  fun onCreate() {
    }


    override fun onDestroy() {
    }
}