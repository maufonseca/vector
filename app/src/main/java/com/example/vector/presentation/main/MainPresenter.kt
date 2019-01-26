package com.example.vector.presentation.main

import android.content.Context
import com.example.vector.R
import com.example.vector.entity.Result

class MainPresenter(private val mainView: MainView,
                    private val context: Context): MainPresentation {

    override fun onNumbersArrived(numbers: List<Int>) {
        mainView.updateNumbers(numbers)
    }

    override fun onBlankVerification() {
        mainView.showMessage(context.getString(R.string.error_bounds))
    }

    override fun onBoundsExceeded() {
        mainView.showMessage(context.getString(R.string.error_bounds))
    }

    override fun onNotExistence() {
        mainView.showMessage(context.getString(R.string.result_not_exist))
        mainView.clearEditText()
    }

    override fun onExistence(result: Result) {
        mainView.showMessage(context.getString(R.string.feedback_result_exist,result.numberA, result.numberB, result.n))
        mainView.clearEditText()
    }
}