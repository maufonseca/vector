package com.example.vector.presentation.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.vector.R

class MainActivity : AppCompatActivity() {

    var mainPresenter: MainPresenter? = null
    var mainInteractor: MainInteractor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createScene()
    }

    private fun createScene() {
        mainInteractor = MainInteractor()
        mainPresenter = MainPresenter()
    }



    private fun destroyScene() {
        mainPresenter = null
        mainInteractor = null
    }

    override fun onDestroy() {
        destroyScene()
        super.onDestroy()
    }
}
