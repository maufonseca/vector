package com.example.vector.infrastructure

import com.example.vector.presentation.main.MainInteraction
import io.reactivex.Observable
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class NumbersServiceImplementation(var api: Api? = null): NumbersService {

    init {
        val retrofit = Retrofit.Builder()
        .baseUrl("https://k9h52hczu2.execute-api.us-east-2.amazonaws.com/prod/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

        api = retrofit.create(Api::class.java)
    }

    override fun getNumbers(): Observable<List<Int>> {
        api?.let { return it.getRandomArray() }
    }
}