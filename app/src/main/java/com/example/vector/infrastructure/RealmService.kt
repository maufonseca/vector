package com.example.vector.infrastructure

import com.example.vector.entity.Result

interface RealmService {

    fun onCreate()
    fun getHistory(): List<Result>
    fun postResult(result: Result)
    fun onDestroy()
}