package com.github.ods.umnozhka

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random


class GameViewModel : ViewModel() {
    private var number1 = 0
    private var number2 = 0
    private var correctAnswer = "0"
    private var userAnswer = ""

    private val _exerciseText = MutableLiveData("")
    val exerciseText: LiveData<String>
        get() = _exerciseText

    fun newExercise() {
        number1 = Random.nextInt(2, 99)
        number2 = Random.nextInt(2, 99)
        userAnswer = ""
        correctAnswer = (number1 * number2).toString()
        updateExerciseText()
    }

    init {
        newExercise()
    }

    private fun updateExerciseText() {
        val answer = userAnswer.padEnd(correctAnswer.length, '_')
        _exerciseText.value = "$number1 × $number2 = $answer"
    }

    fun onNumClicked(num: Int) {
        if (userAnswer.length < correctAnswer.length) {
            userAnswer += num.toString()
            updateExerciseText()
        }
    }

}