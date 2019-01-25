package com.example.vector.entity

import java.io.Serializable

data class Result(
    val n: Int,
    val numbers: List<Int>,
    val existence: Boolean): Serializable