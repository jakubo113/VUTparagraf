package com.example.vutparagraf

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import kotlin.system.exitProcess

class Quiz {

    private var questions: List<Question> = emptyList()
    private var indexOtazky = 0
    private var numberOfCorrectQuestions = 0
    private var con: Context? = null


    constructor(con: Context) {
        val otazky = GetFromFile().dataZoSuboru(con, R.raw.otazky)
        questions = GetFromFile().dataZoSuboru(con, R.raw.otazky).map {
            Question(con, it, otazky.indexOf(it))
        }
        this.con = con
    }

    fun getQuestion(): Question{
       return questions[indexOtazky]
    }

    fun nextQuestion() {
        indexOtazky++
    }


    fun getQuestionsSize(): Int {
        return questions.size
    }

    fun getQuestionNumber(): Int {
        return indexOtazky++
    }


    fun getnumberOfCorrQues(): Int{
        return numberOfCorrectQuestions
    }

    fun isCorrectAnswerText(answer: Answer): String{
        return if (answer.isCorrectAnswer()){
            numberOfCorrectQuestions++
            questions.filterIndexed { index, question -> indexOtazky }
            "Spravne"
        } else
            "Nespravne"
    }

    fun showDialog(){
        val dialog: AlertDialog.Builder = AlertDialog.Builder(con)
        dialog.setTitle("Chcete pokračovať v teste?")

        dialog.setPositiveButton("Áno", DialogInterface.OnClickListener{ dialog, which -> dialog.dismiss(); indexOtazky = 0})
        dialog.setNegativeButton("Nie", DialogInterface.OnClickListener{ dialog, which -> exitProcess(-1) })
        val alertDialog: AlertDialog = dialog.create()
        alertDialog.show()
    }


}