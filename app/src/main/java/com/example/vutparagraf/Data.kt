package com.example.vutparagraf

import android.content.Context

class Data(con: Context): GetFromFile(con) {
    private val correctAnswers = GetFromFile(con).dataZoSuboru(con, R.raw.spravne_odpovede)
    private val allAnswers = GetFromFile(con).dataZoSuboru(con, R.raw.odpovede)
    private val allQuestions = GetFromFile(con).dataZoSuboru(con, R.raw.otazky)

    fun getCorrAswers(): List<String> {
        return correctAnswers
    }
    fun getAllAswers(): List<String> {
        return allAnswers
    }
    fun getAllQuestions(): List<String> {
        return allQuestions
    }
}