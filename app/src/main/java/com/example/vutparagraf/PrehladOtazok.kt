package com.example.vutparagraf
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle;

import android.widget.*


class PrehladOtazok : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.prehlad_otazok)

        var question = Question()
        var answer = Answer()
        val cislo_otazky = findViewById<TextView>(R.id.cisOtazky)
        val otazka = findViewById<TextView>(R.id.otazka)
        val odpoved = findViewById<TextView>(R.id.odpoved)
        val button_back = findViewById<Button>(R.id.tl_back)
        val button_next = findViewById<Button>(R.id.tl_next)
        val button_menu = findViewById<Button>(R.id.tl_menu)
        var j = 0

        fun init(i: Int){
            if (i >= 0 && i < answer.corrAnswers.size) {
                var cislo = "${i + 1} / ${answer.corrAnswers.size}"
                cislo_otazky.text = cislo
                otazka.text = question.makeQuestion(i).toString()
                odpoved.text = answer.corrAnswers[i].toString()
            } else if (i < 0) j = 0 else j = answer.corrAnswers.size-1 //kontrola pretecenia "j" do - alebo na rozmer pola
        }

        init(j)
        button_back.setOnClickListener {
            j--
            init(j)
        }
        button_next.setOnClickListener {
            j++
            init(j)
        }
        button_menu.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}