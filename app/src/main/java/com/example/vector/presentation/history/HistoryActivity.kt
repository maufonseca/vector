package com.example.vector.presentation.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.vector.R
import com.example.vector.entity.Result
import com.example.vector.presentation.history.TableAdapter
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : HistoryView, AppCompatActivity() {

    private val historyPresenter = HistoryPresenter(this)
    private val historyInteractor = HistoryInteractor(historyPresenter)
    private val results: MutableList<Result> = mutableListOf()
    private val adapter = TableAdapter(results, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        historyInteractor.onCreate()
        setupTable()
    }

    private fun setupTable() {
        historyRecyclerView.layoutManager = LinearLayoutManager(this)
        historyRecyclerView.adapter = adapter
    }

    fun backTapped(v: View) {
        finish()
    }

    override fun onDestroy() {
        historyInteractor.onDestroy()
        super.onDestroy()
    }
}
