package com.example.vector.presentation.history

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.vector.R
import com.example.vector.entity.Result
import com.example.vector.infrastructure.RealmServiceImplementation
import com.example.vector.presentation.main.GridAdapter
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.numbers_popup.*

class HistoryActivity : HistoryView, AppCompatActivity() {

    private lateinit var historyPresenter: HistoryPresentation
    private lateinit var historyInteractor: HistoryInteraction

    private val results: MutableList<Result> = mutableListOf()

    private lateinit var gridAdapter: GridAdapter
    private lateinit var tableAdapter: TableAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        setupScene()
        setupTable()

        historyInteractor.onCreate()
    }

    private fun setupScene() {
        historyPresenter = HistoryPresenter(this, this)
        historyInteractor = HistoryInteractor(historyPresenter, RealmServiceImplementation())
    }

    private fun setupTable() {
        historyRecyclerView.layoutManager = LinearLayoutManager(this)
        tableAdapter = TableAdapter(results, this)
        historyRecyclerView.adapter = tableAdapter
    }

    private fun setupGrid(result: Result) {
        gridAdapter = GridAdapter(result.numbers, this, result)
        numbersGrid.layoutManager = GridLayoutManager(this, 4)
        numbersGrid.adapter = gridAdapter
    }

    override fun updateTable(results: List<Result>) {
        this.results.clear()
        this.results.addAll(results)
        tableAdapter.notifyDataSetChanged()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun backTapped(v: View) {
        finish()
    }

    fun clearHistoryTapped(v: View) {
        historyInteractor.onClearHistoryTapped()
    }

    override fun showNumbers() {
        numbersLayout.visibility = View.VISIBLE
    }

    fun historyCellTapped(v: View) {
        val tappedResult: Result = v.tag as Result
        setupGrid(tappedResult)
        showNumbers()
    }

    fun hideNumbersLayout(v: View) {
        numbersLayout.visibility = View.GONE
    }

    override fun onDestroy() {
        historyInteractor.onDestroy()
        super.onDestroy()
    }
}
