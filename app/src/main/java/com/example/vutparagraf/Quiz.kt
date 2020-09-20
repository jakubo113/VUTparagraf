package com.example.vutparagraf

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import kotlin.system.exitProcess

class Quiz {
    var questions = mutableListOf<Question>()
    private var indexOtazky = 0
    private var numberOfCorrectQuestions = 0
    private var questionsSize = 0
    private var con: Context? = null


    constructor(con: Context, random: Boolean) {
        this.con = con
        this.questionsSize = questions.size
        val data = Data(con)
        questions = data.getAllQuestions().map {
            Question(it, data)
        }.toMutableList()
        if (random) questions.shuffle()
    }

    fun getQuestion(): Question{
        return if(indexOtazky < questions.size){
            questions[indexOtazky]
        } else{
            showDialog()
            indexOtazky = 0
            questions[indexOtazky]
        }
    }

    fun nextQuestion() {
        if (numberOfCorrectQuestions < questionsSize)
            indexOtazky++
        else
            exitProcess(-1)
    }

    fun getQuestionsSize(): Int {
        return questionsSize
    }

    fun getnumberOfCorrQues(): Int{
        return numberOfCorrectQuestions
    }

    fun isCorrectAnswerText(answer: Answer): String{
        return if (answer.isCorrectAnswer()){
            numberOfCorrectQuestions++
            questions.remove(questions[indexOtazky])
            indexOtazky-- // Lebo ked vymaze prvoko tak automaticky je hned na dalsom prvku preto treba ked vymze znizit index
            "Spravne"
        } else
            "Nespravne"
    }
    private fun showDialog(){
        val dialog: AlertDialog.Builder = AlertDialog.Builder(con)
        dialog.setTitle("Chcete pokračovať v teste?")

        dialog.setPositiveButton("Áno", DialogInterface.OnClickListener{ dialog, which -> dialog.dismiss()})
        dialog.setNegativeButton("Nie", DialogInterface.OnClickListener{ dialog, which -> exitProcess(-1) })
        val alertDialog: AlertDialog = dialog.create()
        alertDialog.show()
    }

//PRE PREHLAD OTAZOK
    fun changeQuestion(dirrect: Boolean){
         if (dirrect) {
            indexOtazky++
        }else
             indexOtazky--
    }
}