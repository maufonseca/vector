package com.example.vector.entity

data class Result(
    val n: Int,
    val numbers: List<Int>,
    val existence: Boolean,
    val creation: Long = System.currentTimeMillis())