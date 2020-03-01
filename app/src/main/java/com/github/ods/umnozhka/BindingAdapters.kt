package com.github.ods.umnozhka

import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.databinding.BindingAdapter


@BindingAdapter("score")
fun TextView.setScore(value:Int) {
    text = value.toString()
}

@BindingAdapter("scoreIncrement")
fun TextView.setScoreIncrement(value: Int) {
    if (value != 0) {
        text = "+$value"
        val flashAnimation = AnimationUtils.loadAnimation(context, R.anim.flash)
        startAnimation(flashAnimation)
    }
}