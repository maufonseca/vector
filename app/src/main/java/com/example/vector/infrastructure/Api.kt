package com.example.vector.infrastructure

import io.reactivex.Observable
import retrofit2.http.GET

interface Api {

    @GET("random_array_generator")
    fun getRandomArray(): Observable<List<Int>>
}