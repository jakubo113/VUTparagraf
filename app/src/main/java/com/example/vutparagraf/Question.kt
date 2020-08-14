package com.example.vutparagraf

import java.io.File
import java.io.InputStream

class Question {

    //val questions = arrayOf("otazka1", "otazka2", "otazka3", "otazka4")
    val fileName = "/app/src/main/res/raw/otazky.txt"
    val questions: List<String> = File(fileName).readLines()

   /* fun dataZoSuboru(cesta: String): Array<String> {
        val inputStream: InputStream = File(cesta).inputStream()

        var line = arrayOf<String>()
        inputStream.bufferedReader().forEachLine { line += it }
        return line
    }*/
    //val questions = dataZoSuboru("./vutparagraf/otazky.txt")

    fun makeQuestion(i: Int): String {
        //val  cesta = this::class.java.classLoader?.getResource("otazky.txt")?.readText()

        //println("TUUUUUU " + cesta)
        return questions[i]
    }
}