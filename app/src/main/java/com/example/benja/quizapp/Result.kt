package com.example.benja.quizapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text
import android.content.Intent
import android.view.View


class Result : AppCompatActivity() {
    /*
    * I HIGHKEY RUSHED THIS ONE
    * UM SOMETHING NICE TO HAVE: telling you which questions you got wrong
    * try again button (same questions), so maybe you should pass the questionsArr in the intent idk
    *
    *
    * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val scoreBoard = findViewById<TextView>(R.id.scoreSlot)
        var intent = intent
        scoreBoard.text =  "Score: " + intent.getIntExtra("Score" , 1)
    }

    fun tryagin(view: View) {
        val intent = Intent(this@Result,Questions::class.java)
        intent.putExtra("Category", (intent.getIntExtra("Category",0)))
        startActivity(intent)
    }

    fun returnToMenu(view: View) {
        val intent = Intent(this, Category::class.java)
        startActivity(intent)
    }
}
