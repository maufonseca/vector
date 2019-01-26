package com.example.vector.presentation.history

import com.example.vector.infrastructure.RealmService

class HistoryInteractor(private val historyPresenter: HistoryPresentation,
                        private val realmService: RealmService): HistoryInteraction {

    override  fun onCreate() {
        realmService.onCreate()
        historyPresenter.onResultsArrived(realmService.getHistory())
    }

    override fun onDestroy() {
        realmService.onDestroy()
    }
}