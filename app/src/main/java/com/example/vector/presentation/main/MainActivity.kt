package com.example.vector.presentation.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.example.vector.R
import com.example.vector.infrastructure.NumbersServiceImplementation
import com.example.vector.presentation.history.HistoryActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_options.*

class MainActivity : MainView, AppCompatActivity() {

    private lateinit var mainPresenter: MainPresentation
    private lateinit var mainInteractor: MainInteraction

    private val numbers: MutableList<Int> = mutableListOf()
    private val adapter = GridAdapter(numbers, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupScene()
        setupGrid()

        mainInteractor.onCreate()
    }

    private fun setupScene() {
        mainPresenter = MainPresenter(this, this)
        mainInteractor = MainInteractor(mainPresenter, NumbersServiceImplementation())
    }

    private fun setupGrid() {
        gridRecyclerView.layoutManager = GridLayoutManager(this, 4)
        gridRecyclerView.adapter = adapter
    }

    override fun updateNumbers(numbers: List<Int>) {
        this.numbers.clear()
        this.numbers.addAll(numbers)
        adapter.notifyDataSetChanged()
    }

    fun redefineTapped(v: View) {
        mainInteractor.onRedefineTapped()
    }

    fun verifyTapped(v: View) {
        mainInteractor.onVerifyTapped(numberField.text)
    }

    fun historyTapped(v: View) {
        startActivity(Intent(this, HistoryActivity::class.java))
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun clearEditText() {
        numberField.text.clear()
    }

    override fun onDestroy() {
        mainInteractor.onDestroy()
        super.onDestroy()
    }

}
