package com.example.vector.presentation.history

import android.content.Context
import com.example.vector.R
import com.example.vector.entity.Result

class HistoryPresenter(private val historyView: HistoryView,
                       private val context: Context
): HistoryPresentation {

    override fun onResultsArrived(results: List<Result>) {
        historyView.updateTable(results)
    }

    override fun onHistoryCleared() {
        historyView.updateTable(listOf())
    }

    override fun onOperationError() {
        historyView.showMessage(context.getString(R.string.error_persistence))
    }
}