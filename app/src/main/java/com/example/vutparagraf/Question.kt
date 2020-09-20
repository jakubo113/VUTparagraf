package com.example.vutparagraf


import android.content.Context

class Question(private val otazka: String, data: Data) {

    private val otazkaId = data.getAllQuestions().indexOf(otazka)
    private val correctAnswer = data.getCorrAswers()[otazkaId]
    private val possibleTextOfAnswers = data.getAllAswers().subList(otazkaId * 3, (otazkaId * 3) + 3)
    private val possibleAnswers = possibleTextOfAnswers.map {
        val isCorrect = data.getCorrAswers().contains(it)
        Answer(it, isCorrect)
    }.toMutableList()

    fun mixAnswers(){
        possibleAnswers.shuffle()
    }

    fun getAnswers(): List<Answer> {
        return possibleAnswers
    }

    fun getQuestionText(): String {
        return otazka
    }

    fun getQuestionNumber(): Int {
        return otazkaId+1
    }
    fun getCorrAnswer(): String{
        return correctAnswer
    }
}
