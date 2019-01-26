package com.example.vector.infrastructure

import com.example.vector.entity.Result

interface RealmService {

    fun getHistory(): List<Result>
    fun postResult(result: Result)
}