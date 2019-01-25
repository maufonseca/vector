package com.example.vector.presentation.main

import com.example.vector.infrastructure.NumbersService
import com.example.vector.infrastructure.onDefaultSchedulers
import io.reactivex.disposables.CompositeDisposable

class MainInteractor(private val mainPresenter: MainPresentation,
                     private val numbersService: NumbersService): MainInteraction {

    private var numbers: List<Int>? = null
    private val compositeDisposable = CompositeDisposable()

    override  fun onCreate() {
        subscribe()
    }

    private fun subscribe() {
        compositeDisposable.add(numbersService.getNumbers()
            .onDefaultSchedulers()
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