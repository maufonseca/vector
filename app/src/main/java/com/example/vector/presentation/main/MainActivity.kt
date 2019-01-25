package com.example.vector.presentation.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.example.vector.R
import com.example.vector.infrastructure.NumbersServiceImplementation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MainView, AppCompatActivity() {

    private val mainPresenter = MainPresenter(this)
    private val mainInteractor = MainInteractor(mainPresenter, NumbersServiceImplementation())
    private val numbers: MutableList<Int> = mutableListOf()
    private val adapter = GridAdapter(numbers, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainInteractor.onCreate()
        setupGrid()
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

    override fun onDestroy() {
        mainInteractor.onDestroy()
        super.onDestroy()
    }

    fun redefineTapped(v: View) {
        mainInteractor.onRedefineTapped()
    }

    fun verifyTapped(v: View) {

    }

    fun historyTapped(v: View) {

    }
}
