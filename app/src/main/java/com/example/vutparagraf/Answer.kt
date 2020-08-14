package com.example.vutparagraf

import android.widget.Toast
import java.lang.reflect.Array

class Answer {
    val Answers = arrayOf("odpoved1", "odpoved1a", "odpoved1b",
        "odpoved2", "odpoved2a", "odpoved2b",
        "odpoved3", "odpoved3a", "odpoved3b",
        "odpoved4", "odpoved4a", "odpoved4b")
    val corrAnswers = arrayOf("odpoved1", "odpoved2", "odpoved3", "odpoved4")

    fun posibilities(i: Int): String {
        return Answers[i]
    }

    fun answer(question: String): String{
        if (corrAnswers.contains(question))
            return "Spravne"
        else
            return "Nespravne"

    }
}