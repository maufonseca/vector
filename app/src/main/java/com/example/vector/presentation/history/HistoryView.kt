package com.example.vector.presentation.history

import com.example.vector.entity.Result

interface HistoryView {

    fun updateTable(results: List<Result>)
    fun showNumbers()
    fun showMessage(message: String)
}