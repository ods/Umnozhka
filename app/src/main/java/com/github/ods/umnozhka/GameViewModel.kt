package com.github.ods.umnozhka

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class GameViewModel : ViewModel() {

    private val _exerciseText = MutableLiveData("54 × 32 = ____")
    val exerciseText: LiveData<String>
        get() = _exerciseText

}