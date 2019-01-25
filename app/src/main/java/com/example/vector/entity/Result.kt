package com.example.vector.entity

import io.realm.RealmObject

data class Result(
    val n: Int,
    val numbers: List<Int>,
    val existence: Boolean): RealmObject()