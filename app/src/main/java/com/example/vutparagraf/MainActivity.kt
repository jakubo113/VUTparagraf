package com.example.vutparagraf

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent;
import android.os.Bundle;

import android.widget.*
import kotlinx.android.synthetic.main.menu.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)
        val button_test_prehlad = findViewById<Button>(R.id.b_prehlad_ot)
        val button_test_por = findViewById<Button>(R.id.b_test_por)
        val button_test_nah_por = findViewById<Button>(R.id.b_test_nah)
        val button_koniec = findViewById<Button>(R.id.b_koniec)
        button_test_prehlad.setOnClickListener {
            val intent = Intent(this, PrehladOtazok::class.java)
            startActivity(intent)
        }
        button_test_por.setOnClickListener {
            val intent = Intent(this, Vporadi::class.java)
            startActivity(intent)
        }
        button_test_nah_por.setOnClickListener {
            val intent = Intent(this, Nahodne::class.java)
            startActivity(intent)
        }
        button_koniec.setOnClickListener {
            moveTaskToBack(true)
            exitProcess(-1)

        }
    }
}
