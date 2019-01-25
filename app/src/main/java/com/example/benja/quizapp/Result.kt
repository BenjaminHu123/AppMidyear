package com.example.benja.quizapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val scoreBoard = findViewById<TextView>(R.id.scoreSlot)
        var intent = intent
        scoreBoard.text =  "Score: " + intent.getIntExtra("Score" , 1)
    }
}
