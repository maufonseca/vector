package com.example.vector.presentation.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.vector.R
import com.example.vector.infrastructure.NumbersServiceImplementation
import kotlinx.android.synthetic.main.activity_main.*

class ResultActivity : ResultView, AppCompatActivity() {

    private val resultPresenter = ResultPresenter(this)
    private val resultInteractor = ResultInteractor(resultPresenter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultInteractor.onCreate()
    }

    override fun onDestroy() {
        resultInteractor.onDestroy()
        super.onDestroy()
    }
}
