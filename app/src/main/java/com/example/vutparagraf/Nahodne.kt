package com.example.vutparagraf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.*
import kotlinx.android.synthetic.main.menu.*

class Nahodne : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var question = Question()
        var answer = Answer()
        var pole = arrayListOf<Int>()
        val cislo_otazky = findViewById<TextView>(R.id.cisOtazky)
        val otazka = findViewById<TextView>(R.id.otazka)
        val button_ot1 = findViewById<Button>(R.id.tl1)
        val button_ot2 = findViewById<Button>(R.id.tl2)
        val button_ot3 = findViewById<Button>(R.id.tl3)
        val button_back = findViewById<Button>(R.id.tl_back)
        var j = 0
        for (i in 0..answer.corrAnswers.size-1){
            pole.add(i)
        }
        fun init(j: Int){
            if (j < answer.corrAnswers.size){
                var i = pole[j]
                var cislo = "${pole[i]+1} / ${answer.corrAnswers.size}"
                cislo_otazky.text =  cislo
                otazka.text = question.makeQuestion(pole[i])
                button_ot1.text = answer.posibilities(pole[i]*3)
                button_ot2.text = answer.posibilities((pole[i]*3)+1)
                button_ot3.text = answer.posibilities((pole[i]*3)+2)
            }else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }

        pole.shuffle()
        init(j)
        button_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        button_ot1.setOnClickListener {
            Toast.makeText(applicationContext,answer.answer(button_ot1.text.toString()),Toast.LENGTH_SHORT).show()
            j++
            init(j)
        }
        button_ot2.setOnClickListener {
            Toast.makeText(applicationContext,answer.answer(button_ot2.text.toString()),Toast.LENGTH_SHORT).show()
            j++
            init(j)
        }
        button_ot3.setOnClickListener {
            Toast.makeText(applicationContext,answer.answer(button_ot3.text.toString()),Toast.LENGTH_SHORT).show()
            j++
            init(j)
        }
    }
}