package com.example.vector.presentation.history

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.vector.R
import com.example.vector.entity.Result
import com.example.vector.infrastructure.RealmServiceImplementation
import com.example.vector.presentation.history.TableAdapter
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : HistoryView, AppCompatActivity() {

    private lateinit var historyPresenter: HistoryPresentation
    private lateinit var historyInteractor: HistoryInteraction

    private val results: MutableList<Result> = mutableListOf()
    private val adapter = TableAdapter(results, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        setupScene()
        setupTable()

        historyInteractor.onCreate()
    }

    private fun setupScene() {
        historyPresenter = HistoryPresenter(this)
        historyInteractor = HistoryInteractor(historyPresenter, RealmServiceImplementation())
    }

    private fun setupTable() {
        historyRecyclerView.layoutManager = LinearLayoutManager(this)
        historyRecyclerView.adapter = adapter
    }

    override fun updateTable(results: List<Result>) {
        this.results.clear()
        this.results.addAll(results)
        adapter.notifyDataSetChanged()
    }

    fun backTapped(v: View) {
        finish()
    }

    override fun onDestroy() {
        historyInteractor.onDestroy()
        super.onDestroy()
    }
}
