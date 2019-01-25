package com.example.vector.presentation.history

import com.example.vector.entity.Result

class HistoryPresenter(val historyView: HistoryView): HistoryPresentation {

    override fun onResultsArrived(results: List<Result>) {
        historyView.updateTable(results)
    }
}