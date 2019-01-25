package com.example.vector.infrastructure

import io.reactivex.Observable

interface NumbersService {

    fun getNumbers(): Observable<List<Int>>

}