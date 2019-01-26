package com.example.vector.infrastructure

import com.example.vector.entity.RealmHistory
import com.example.vector.entity.Result
import io.realm.Realm
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
            response.add(Result(it.n, listOf(), it.existence, it.creation))
        }

        return response.sortedBy { it.creation }.reversed()
    }

    override fun postResult(result: Result) {
        realm.beginTransaction()
        val history = realm.createObject(RealmHistory::class.java, UUID.randomUUID().toString())
        history?.creation = result.creation
        history?.n = result.n
        history?.existence = result.existence
        realm.commitTransaction()
        realm.close()
    }

    override fun onDestroy() {
        realm.close()
    }
}