package com.example.vector.infrastructure

import com.example.vector.entity.RealmHistory
import com.example.vector.entity.Result
import io.realm.Realm
import java.lang.Exception
import java.util.*

class RealmServiceImplementation: RealmService {

    private lateinit var realm: Realm

    override fun onCreate() {
        realm = Realm.getDefaultInstance()
    }

    override fun getHistory(): List<Result> {
        val response = mutableListOf<Result>()

        val realmList = realm.where(RealmHistory::class.java).findAll()
        realmList?.forEach {
            val numbers = mutableListOf<Int>()
            numbers.addAll(it.numbers)
            response.add(Result(it.n, numbers, it.existence, it.numberA, it.numberB, it.creation))
        }

        return response.sortedBy { it.creation }.reversed()
    }

    override fun postResult(result: Result) {
        realm.beginTransaction()
        val history = realm.createObject(RealmHistory::class.java, UUID.randomUUID().toString())
        history?.let {
            it.creation = result.creation
            it.n = result.n
            it.numbers.addAll(result.numbers)
            it.existence = result.existence
            it.numberA = result.numberA
            it.numberB = result.numberB
        }
        realm.commitTransaction()
    }

    override fun clearHistory(): Boolean {
        try {
            realm.beginTransaction()
            realm.deleteAll()
            realm.commitTransaction()
        } catch (e: Exception) { return false }
        return true
    }

    override fun onDestroy() {
        realm.close()
    }
}