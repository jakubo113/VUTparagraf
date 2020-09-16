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

    private val possibleAnswers = allAnswers.subList(otazkaId * 3, (otazkaId * 3) + 3)

    fun getAnswers(): List<Answer> {
        return possibleAnswers.map {
            val isCorrect = correctAnswers.contains(it)
            Answer(it, isCorrect)
        }
    }

    fun getQuestionText(): String {
        return otazka
    }

    fun getQuestionCorrectness(): Int {
        return otazkaId
    }
}
