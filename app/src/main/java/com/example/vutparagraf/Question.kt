package com.example.vutparagraf


import android.content.Context
import kotlin.properties.Delegates

class Question(con: Context, private val otazka: String , private val otazkaId:Int) {
    /* Question
*   - P: text (otazka)
*   - P: possibleAnswers => List<Answer>
*   - M: answer(answer)
*   - M: getAnswers() => List<Answer>
*   - M: getQuestionText() => string
*
* Quiz
*   - P: questions: List<Question>
*   - P: actualQuestionIndex++ [index]
*   - M: nextQuestion()
*   - M: getResult()
*/

    private val correctAnswers = GetFromFile().dataZoSuboru(con, R.raw.spravne_odpovede)
    private val allAnswers = GetFromFile().dataZoSuboru(con, R.raw.odpovede)

    private val possibleTextOfAnswers = allAnswers.subList(otazkaId * 3, (otazkaId * 3) + 3)
    private val possibleAnswers = possibleTextOfAnswers.map {
        val isCorrect = correctAnswers.contains(it)
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
        return correctAnswers[otazkaId]
    }
}
