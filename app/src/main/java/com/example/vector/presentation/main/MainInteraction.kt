package com.example.vector.presentation.main

import android.text.Editable

interface MainInteraction {

    fun onCreate()
    fun onDestroy()
    fun onRedefineTapped()
    fun onVerifyTapped(typedText: Editable)
    fun onHistoryTapped()

}