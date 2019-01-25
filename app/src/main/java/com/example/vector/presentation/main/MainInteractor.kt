package com.example.vector.presentation.main

import com.example.vector.infrastructure.NumbersService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainInteractor(private val mainPresenter: MainPresentation,
                     private val numbersService: NumbersService): ResultInteraction {

    private var numbers: List<Int>? = null
    private val compositeDisposable = CompositeDisposable()

    override  fun onCreate() {
        subscribe()
    }

    private fun subscribe() {
        compositeDisposable.add(numbersService.getNumbers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    numbers = it
                    mainPresenter.onNumbersArrived(it)
                },
                { it.printStackTrace() }
            )
        )
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }
}