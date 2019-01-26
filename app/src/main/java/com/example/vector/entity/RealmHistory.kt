package com.example.vector.entity

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RealmHistory: RealmObject() {
    @PrimaryKey
    var id: String? = null
    var creation: Long = 0
    var numbers = RealmList<Int>()
    var n: Int = 0
    var existence: Boolean = false
    var numberA: Int? = null
    var numberB: Int? = null
}