package com.example.vector.presentation.main

class CheckSumUtils {

    companion object {

        fun checkSum(numbers: List<Int>, sum: Int): Boolean {
            numbers.forEach {
                val x = sum - it

                if(numbers.contains(x) and (x != it)) {
                    return true
                }
            }
            return false
        }
    }
}