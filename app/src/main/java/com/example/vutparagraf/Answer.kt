package com.example.vutparagraf

import android.content.Context

class Answer(odpoved: String, isCorrect: Boolean) {
    var  odpoved: String = odpoved
    private var isCorrect: Boolean = isCorrect

    fun isCorrectAnswer(): Boolean {
        return isCorrect
    }
}


