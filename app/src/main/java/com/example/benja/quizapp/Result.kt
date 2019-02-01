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
        val qwrong = findViewById<TextView>(R.id.Qwrong)
        var intent = intent
        scoreBoard.text =  "Score: " + intent.getIntExtra("Score" , 1)
        val questions = intent.getStringArrayListExtra("Questions")
        val corrections = intent.getStringArrayListExtra("Corrections")
        val userAns = intent.getStringArrayListExtra("userAns")
        var str = ""
        for(i in questions.indices){
            str += ("Question: " + questions.get(i) + "\n\n"
                    + "Correct Answer: " + corrections.get(i) +
                    "\nYour Answer: " + userAns.get(i) + "\n\n")
        }
        qwrong.text = adjustString(str)
    }

    fun tryagain(view: View) {
        var intent = intent
        val x : Int = intent.getIntExtra("Category",0)
        intent = Intent(this@Result,Questions::class.java)
        intent.putExtra("Category", x)
        startActivity(intent)
    }

    fun returnToMenu(view: View) {
        val intent = Intent(this, Category::class.java)
        startActivity(intent)
    }
    private fun adjustString(str : String):String{
        return str.replace("\\n","\n")
            .replace("\\t","\t")
            .replace("\\" + "\"","\"")
    }
}
