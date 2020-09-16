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
/*        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val question = Question(this)
        val answer = Answer(this)
        val poleOtazok = arrayListOf<Int>()
        var poleSpravnychOdpovedi = arrayOf<Int>()
        val cislo_otazky = findViewById<TextView>(R.id.cisOtazky)
        val pocetSpravnych = findViewById<TextView>(R.id.pocetSpravnych)
        val otazka = findViewById<TextView>(R.id.otazka)
        val button_ot1 = findViewById<Button>(R.id.tl1)
        val button_ot2 = findViewById<Button>(R.id.tl2)
        val button_ot3 = findViewById<Button>(R.id.tl3)

        var cisOtazka = -1
        var counterSpravnych = 0
        var toast: Toast? = null

        for (i in 0..answer.sizeOfCorrAnsw()-1){
            poleOtazok.add(i)
        }
        poleOtazok.shuffle()

        fun showDialog(){
            val dialog: AlertDialog.Builder = AlertDialog.Builder(this)
            dialog.setTitle("Chcete pokračovať v teste?")

            dialog.setPositiveButton("Áno", DialogInterface.OnClickListener{ dialog, which -> dialog.dismiss()})
            dialog.setNegativeButton("Nie", DialogInterface.OnClickListener{ dialog, which -> exitProcess(-1) })
            val alertDialog: AlertDialog = dialog.create()
            alertDialog.show()
        }
        fun makeToastik(text: String): Toast {
            var t = Toast.makeText(applicationContext,text,Toast.LENGTH_SHORT)
            t.show()
            return t
        }
        // ZOBRATOVANIE ACTIVITY<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        fun showData(cisOtazky: Int, pocSpravnych: Int){
            var i = poleOtazok[cisOtazky]
            val cislo = "č.otázky: ${poleOtazok.indexOf(i)+1} / ${answer.sizeOfCorrAnsw()}"
            cislo_otazky.text =  cislo
            val pocet = "správne: ${pocSpravnych} / ${answer.sizeOfCorrAnsw()}"
            pocetSpravnych.text = pocet
            otazka.text = question.makeQuestion(poleOtazok[i])
            button_ot1.text = answer.posibilities(poleOtazok[i]*3)
            button_ot2.text = answer.posibilities((poleOtazok[i]*3)+1)
            button_ot3.text = answer.posibilities((poleOtazok[i]*3)+2)
        }
        // LOGIKA ZOBRAZOVANIA OTAZOK<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        fun init(i: Int, pocetSpravnych: Int, poleSpravnychOdpovedi: kotlin.Array<Int>): Int {
            var cisOtazky = i + 1
            when {
                cisOtazky < answer.corrAnswers.size && pocetSpravnych < answer.sizeOfCorrAnsw()-> {
                    while (cisOtazky < answer.corrAnswers.size){
                        if (!poleSpravnychOdpovedi.contains(cisOtazky)) {
                            showData(cisOtazky,pocetSpravnych)
                            break
                        }else{
                            cisOtazky++
                        }
                        if(cisOtazky == answer.corrAnswers.size){
                            cisOtazky = init(-1, pocetSpravnych,poleSpravnychOdpovedi)
                            break//TOTO----------------------------------------<<<<<<<<<<<<<<<<<<<<<<<
                        }
                    }
                }
                pocetSpravnych < answer.sizeOfCorrAnsw() -> {
                    showDialog()
                    cisOtazky = init(-1, pocetSpravnych,poleSpravnychOdpovedi)
                }
                else -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
            return cisOtazky
        }


        cisOtazka = init(cisOtazka, counterSpravnych,poleSpravnychOdpovedi)

        button_ot1.setOnClickListener {
            if (toast != null){toast?.cancel()}
            toast = makeToastik(answer.answer(button_ot1.text.toString()))
            if (answer.answertrue(button_ot1.text.toString())) {counterSpravnych++; poleSpravnychOdpovedi += cisOtazka}
            cisOtazka = init(cisOtazka,counterSpravnych,poleSpravnychOdpovedi )
        }
        button_ot2.setOnClickListener {
            if (toast != null){toast?.cancel()}
            toast = makeToastik(answer.answer(button_ot2.text.toString()))
            if (answer.answertrue(button_ot2.text.toString())) {counterSpravnych++; poleSpravnychOdpovedi += cisOtazka}
            cisOtazka = init(cisOtazka,counterSpravnych,poleSpravnychOdpovedi )
        }
        button_ot3.setOnClickListener {
            if (toast != null){toast?.cancel()}
            toast = makeToastik(answer.answer(button_ot3.text.toString()))
            if (answer.answertrue(button_ot3.text.toString())) {counterSpravnych++; poleSpravnychOdpovedi += cisOtazka}
            cisOtazka = init(cisOtazka,counterSpravnych,poleSpravnychOdpovedi )
        }*/
    }
}