package com.example.vector.presentation.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.vector.R

class HistoryActivity : HistoryView, AppCompatActivity() {

    private val historyPresenter = HistoryPresenter(this)
    private val historyInteractor = HistoryInteractor(historyPresenter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        historyInteractor.onCreate()
    }

    override fun onDestroy() {
        historyInteractor.onDestroy()
        super.onDestroy()
    }
}
