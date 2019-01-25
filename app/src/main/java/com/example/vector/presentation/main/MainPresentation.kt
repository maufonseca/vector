package com.example.vector.presentation.main

interface MainPresentation {
    fun onNumbersArrived(numbers: List<Int>)
    fun onBlankVerification()
    fun onBoundsExceeded()
    fun onExistence()
    fun onNotExistence()
}