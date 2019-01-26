package com.example.vector.presentation.history

import com.example.vector.entity.Result

interface HistoryPresentation {
    fun onResultsArrived(results: List<Result>)
    fun onHistoryCleared()
    fun onOperationError()
}