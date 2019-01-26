package com.example.vector.infrastructure

import com.example.vector.entity.Result
import io.realm.Realm

class RealmServiceImplementation(): RealmService {

    val realm = Realm.getDefaultInstance()

    override fun getHistory(): List<Result> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun postResult(result: Result) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}