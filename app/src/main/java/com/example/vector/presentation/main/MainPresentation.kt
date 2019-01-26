package com.example.vector.presentation.main

import com.example.vector.entity.Result

interface MainPresentation {
    fun onNumbersArrived(numbers: List<Int>)
    fun onBlankVerification()
    fun onBoundsExceeded()
    fun onExistence(result: Result)
    fun onNotExistence()
}