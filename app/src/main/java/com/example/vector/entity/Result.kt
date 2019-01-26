package com.example.vector.entity

data class Result(
    val n: Int,
    val numbers: List<Int>,
    val existence: Boolean,
    var numberA: Int? = null,
    var numberB: Int? = null,
    val creation: Long = System.currentTimeMillis())