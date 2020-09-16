package com.example.vutparagraf

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class Vporadi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        val question = Question(this)
//        val answer = Answer(this)
        // OBJEKTY
        val quiz = Quiz(this)
        // INICIALIZACIA LAYOUT
        val cislo_otazky = findViewById<TextView>(R.id.cisOtazky)
        val pocetSpravnych = findViewById<TextView>(R.id.pocetSpravnych)
        val otazka = findViewById<TextView>(R.id.otazka)
        val button_ot1 = findViewById<Button>(R.id.tl1)
        val button_ot2 = findViewById<Button>(R.id.tl2)
        val button_ot3 = findViewById<Button>(R.id.tl3)
        // POMOCNE PREMENNE
        /*var poleSpravnychOdpovedi = arrayOf<Int>()
        var cisOtazka = -1
        var counterSpravnych = 0*/
        var toast: Toast? = null

        fun makeToastik(text: String): Toast {
            var t = Toast.makeText(applicationContext,text,Toast.LENGTH_SHORT)
            t.show()
            return t
        }
//        fun showData(cisOtazky: Int, pocSpravnych: Int){
//            val cislo = "č.otázky: ${cisOtazky + 1} / ${answer.sizeOfCorrAnsw()}"
//            cislo_otazky.text = cislo
//            val pocet = "správne: ${pocSpravnych} / ${answer.sizeOfCorrAnsw()}"
//            pocetSpravnych.text = pocet
//            otazka.text = question.makeQuestion(cisOtazky)
//            button_ot1.text = answer.posibilities((cisOtazky * 3))
//            button_ot2.text = answer.posibilities((cisOtazky * 3) + 1)
//            button_ot3.text = answer.posibilities((cisOtazky * 3) + 2)
//        }


        /**
         *
         * class Question {
         *
         *    Question(answers, questionText) {
         *       this.answers = answers;
         *       questionText = questionText
         *    }
         *
         *    bool answer(Answer answer) {
         *       return answer.isCorrect();
         *    }
         *
         *    getAnswers()
         *       return this.answers;
         *    }
         *
         *    getQuestionText() ...
         * }
         *
         * new Answer("Ohmov zakon", true/false);
         *
         *
         * Answer
         *   - P: text (odpoved)
         *   - P: correct (bool)
         *   - construct(text, correct)
         *   - M: isCorrectAnswer(): bool
         *
         * Question
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

        fun showData(question: Question){
            val cislo = "č.otázky: ${quiz.getQuestionNumber()} / ${quiz.getQuestionsSize()}"
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
            //if (answer.answertrue(button_ot1.text.toString())) {counterSpravnych++; poleSpravnychOdpovedi += cisOtazka}
            quiz.nextQuestion()
            showData(quiz.getQuestion())
        }
        button_ot2.setOnClickListener {
            if (toast != null){toast?.cancel()}
            toast = makeToastik(quiz.isCorrectAnswerText(quiz.getQuestion().getAnswers()[1]))
            //if (answer.answertrue(button_ot2.text.toString())) {counterSpravnych++; poleSpravnychOdpovedi += cisOtazka}
            quiz.nextQuestion()
            showData(quiz.getQuestion())
        }
        button_ot3.setOnClickListener {
            if (toast != null){toast?.cancel()}
            toast = makeToastik(quiz.isCorrectAnswerText(quiz.getQuestion().getAnswers()[2]))
            //if (answer.answertrue(button_ot3.text.toString())) {counterSpravnych++; poleSpravnychOdpovedi += cisOtazka}
            quiz.nextQuestion()
            showData(quiz.getQuestion())
        }
    }
}