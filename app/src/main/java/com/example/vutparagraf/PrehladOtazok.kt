package com.example.vutparagraf
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle;

import android.widget.*


class PrehladOtazok : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.prehlad_otazok)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val quiz = Quiz(this, false)
        val cislo_otazky = findViewById<TextView>(R.id.cisOtazky)
        val otazka = findViewById<TextView>(R.id.otazka)
        val odpoved = findViewById<TextView>(R.id.odpoved)
        val button_back = findViewById<Button>(R.id.tl_back)
        val button_next = findViewById<Button>(R.id.tl_next)

        fun showData(question: Question){
            var cislo = "${question.getQuestionNumber()} / ${quiz.getQuestionsSize()}"
            cislo_otazky.text = cislo
            otazka.text = question.getQuestionText()
            odpoved.text = question.getCorrAnswer()
        }

        fun checkState(){
            when {
                quiz.getQuestion().getQuestionNumber() <= 1 -> button_back.isEnabled = false
                quiz.getQuestion().getQuestionNumber() >= quiz.getQuestionsSize() -> button_next.isEnabled = false
                else -> {
                    button_next.isEnabled = true
                    button_back.isEnabled = true
                }
            }
        }

        showData(quiz.getQuestion())
        checkState()

        button_back.setOnClickListener {
            quiz.changeQuestion(false)
            checkState()
            showData(quiz.getQuestion())
        }
        button_next.setOnClickListener {
            quiz.changeQuestion(true)
            checkState()
            showData(quiz.getQuestion())
        }
    }
}