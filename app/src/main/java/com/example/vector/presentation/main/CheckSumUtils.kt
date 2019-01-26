package com.example.vector.presentation.main

import com.example.vector.entity.Result

class CheckSumUtils {

    companion object {

        fun checkSum(numbers: List<Int>, sum: Int): Result {
            numbers.forEach {
                val x = sum - it

                if(numbers.contains(x) and (x != it)) {
                    return Result(sum, numbers, true, x, it)
                }
            }
            return Result(sum, numbers, false)
        }
    }
}