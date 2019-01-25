package com.example.vector.presentation.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.vector.R
import com.example.vector.infrastructure.NumbersServiceImplementation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MainView, AppCompatActivity() {

    private val mainPresenter = MainPresenter(this)
    private val mainInteractor = MainInteractor(mainPresenter, NumbersServiceImplementation())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainInteractor.onCreate()
    }


    override fun updateNumbers(numbers: List<Int>) {
        text.text = numbers.toString()
    }

    override fun onDestroy() {
        mainInteractor.onDestroy()
        super.onDestroy()
    }
}
