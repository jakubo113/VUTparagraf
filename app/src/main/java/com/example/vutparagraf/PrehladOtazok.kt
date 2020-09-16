package com.example.vutparagraf
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle;

import android.widget.*


class PrehladOtazok : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.prehlad_otazok)
    /*    supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var question = Question(this)
        var answer = Answer(this)
        val cislo_otazky = findViewById<TextView>(R.id.cisOtazky)
        val otazka = findViewById<TextView>(R.id.otazka)
        val odpoved = findViewById<TextView>(R.id.odpoved)
        val button_back = findViewById<Button>(R.id.tl_back)
        val button_next = findViewById<Button>(R.id.tl_next)
        var j = 0

        fun init(i: Int){
            if (i >= 0 && i < answer.sizeOfCorrAnsw()) {
                button_back.isEnabled = true
                button_next.isEnabled = true
                var cislo = "${i + 1} / ${answer.sizeOfCorrAnsw()}"
                cislo_otazky.text = cislo
                otazka.text = question.makeQuestion(i).toString()
                odpoved.text = answer.corrAnswer(i).toString()
            }
            if (i <= 0) {//kontrola pretecenia "j" do - alebo na rozmer pola
                j = 0
                button_back.isEnabled = false
            }
            if(i >= answer.sizeOfCorrAnsw()-1) {
                j = answer.sizeOfCorrAnsw()-1
                button_next.isEnabled = false
            }
        }

        init(j)
        button_back.setOnClickListener {
            j--
            init(j)
        }
        button_next.setOnClickListener {
            j++
            init(j)
        }*/

    }
}