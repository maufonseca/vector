package com.example.vector.presentation.main

import android.text.Editable
import com.example.vector.infrastructure.NumbersService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainInteractor(private val mainPresenter: MainPresentation,
                     private val numbersService: NumbersService): MainInteraction {

    private var numbers: List<Int> = emptyList()
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

    private fun checkSum(sum: Int) {
        with(CheckSumUtils.checkSum(numbers, sum)) {
            if(existence) mainPresenter.onExistence() else mainPresenter.onNotExistence()
        }
    }

    override fun onHistoryTapped() {}

    override fun onVerifyTapped(typedText: Editable) {
        with(typedText.toString()) {
            ifBlank {
                mainPresenter.onBlankVerification()
                return
            }
            val typedNumber = Integer.parseInt(typedText.toString())
            if (typedNumber !in -197..197 ) mainPresenter.onBoundsExceeded() else checkSum(typedNumber)
        }
    }

    override fun onRedefineTapped() {
        subscribe()
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }
}