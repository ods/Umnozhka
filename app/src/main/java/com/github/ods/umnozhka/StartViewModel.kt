package com.github.ods.umnozhka

import androidx.lifecycle.ViewModel


class StartViewModel : ViewModel() {
    val startPressed = SingleLiveEvent<Unit>()

    fun onStartClicked() {
        startPressed.value = null
    }
}
