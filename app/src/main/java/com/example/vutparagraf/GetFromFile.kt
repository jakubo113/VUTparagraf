package com.example.vutparagraf

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

open class GetFromFile(con: Context) {
    fun dataZoSuboru(ctx: Context, idSuboru: Int): List<String> {
        val inputStream = ctx.resources.openRawResource(idSuboru)
        val inputreader = InputStreamReader(inputStream)
        val buffreader = BufferedReader(inputreader)
        //var line: String = buffreader.readLine
        val questions: List<String> = buffreader.readLines()
        //println(R.raw.otazky)
        return questions
    }
}