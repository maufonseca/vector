package com.example.vector.presentation.main

interface MainView {
    fun updateNumbers(numbers: List<Int>)
    fun showMessage(message: String)
    fun clearEditText()
}