package com.example.vutparagraf

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.*
import kotlin.system.exitProcess

class Nahodne : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // OBJEKTY
        val quiz = Quiz(this, true)
        // INICIALIZACIA LAYOUT
        val cislo_otazky = findViewById<TextView>(R.id.cisOtazky)
        val pocetSpravnych = findViewById<TextView>(R.id.pocetSpravnych)
        val otazka = findViewById<TextView>(R.id.otazka)
        val button_ot1 = findViewById<Button>(R.id.tl1)
        val button_ot2 = findViewById<Button>(R.id.tl2)
        val button_ot3 = findViewById<Button>(R.id.tl3)
        // POMOCNE PREMENNE
        var toast: Toast? = null

        fun makeToastik(text: String): Toast {
            var t = Toast.makeText(applicationContext,text,Toast.LENGTH_SHORT)
            t.show()
            return t
        }

        fun showData(question: Question){
            val cislo = "č.otázky: ${question.getQuestionNumber()} / ${quiz.getQuestionsSize()}"
            cislo_otazky.text = cislo
            val pocet = "správne: ${quiz.getnumberOfCorrQues()} / ${quiz.getQuestionsSize()}"
            pocetSpravnych.text = pocet
            otazka.text = question.getQuestionText()
            button_ot1.text = question.getAnswers()[0].odpoved
            button_ot2.text = question.getAnswers()[1].odpoved
            button_ot3.text = question.getAnswers()[2].odpoved
        }

        showData(quiz.getQuestion())

        button_ot1.setOnClickListener {
            if (toast != null){toast?.cancel()}
            toast = makeToastik(quiz.isCorrectAnswerText(quiz.getQuestion().getAnswers()[0]))
            quiz.nextQuestion()
            showData(quiz.getQuestion())
        }
        button_ot2.setOnClickListener {
            if (toast != null){toast?.cancel()}
            toast = makeToastik(quiz.isCorrectAnswerText(quiz.getQuestion().getAnswers()[1]))
            quiz.nextQuestion()
            showData(quiz.getQuestion())
        }
        button_ot3.setOnClickListener {
            if (toast != null){toast?.cancel()}
            toast = makeToastik(quiz.isCorrectAnswerText(quiz.getQuestion().getAnswers()[2]))
            quiz.nextQuestion()
            showData(quiz.getQuestion())
        }
    }
}