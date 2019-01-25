package com.example.vector.presentation.main

class MainPresenter(val mainView: MainView): MainPresentation {

    override fun onNumbersArrived(numbers: List<Int>) {
        mainView.updateNumbers(numbers)
    }
}