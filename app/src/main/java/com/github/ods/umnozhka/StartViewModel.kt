package com.github.ods.umnozhka

import androidx.lifecycle.ViewModel


class StartViewModel : ViewModel() {
    val startPressed = SingleLiveEvent<Nothing>()

    fun onStartClicked() {
        startPressed.value = null
    }
}
