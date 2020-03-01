package com.github.ods.umnozhka

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random


enum class GameState {
    WAIT, WIN, LOSS
}

class GameViewModel : ViewModel() {
    private var number1 = 0
    private var number2 = 0
    private var correctAnswer = "0"
    private var userAnswer = ""

    private val _state = MutableLiveData(GameState.WAIT)
    val state: LiveData<GameState>
        get() = _state

    private val _exerciseText = MutableLiveData("")
    val exerciseText: LiveData<String>
        get() = _exerciseText

    private val _score = MutableLiveData(0)
    val score: LiveData<Int>
        get() = _score

    val scoreIncrement = SingleLiveEvent<Int>()

    fun newExercise() {
        _state.value = GameState.WAIT
        number1 = Random.nextInt(2, 9)
        number2 = Random.nextInt(2, 9)
        userAnswer = ""
        correctAnswer = (number1 * number2).toString()
        updateExerciseText()
    }

    init {
        newExercise()
    }

    private fun updateExerciseText() {
        val answer = userAnswer.padEnd(correctAnswer.length, '\u00A0')
        _exerciseText.value = "$number1 × $number2 = $answer"
    }

    private fun addScore(inc: Int) {
        _score.value = (_score.value ?: 0) + inc
        scoreIncrement.value = inc
    }

    fun onNumClicked(num: Int) {
        if (_state.value == GameState.WAIT) {
            val newAnswer = userAnswer + num.toString()
            if (!correctAnswer.startsWith(newAnswer)) {
                _state.value = GameState.LOSS
            } else {
                userAnswer = newAnswer
                updateExerciseText()
                if (userAnswer == correctAnswer) {
                    _state.value = GameState.WIN
                    addScore(1)
                }
            }
        }
    }

}