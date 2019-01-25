package com.example.benja.quizapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_questions.*

class Questions : AppCompatActivity() {

    var questionNumber: Int = 0        //questionNumber keeps track of current Q, 0 is starting
    var score: Int = 0
    var questionsArr = Array(10, {i -> Question("","", "","","","",1)})
    var userAns = Array(10,{i -> 6})
    var chosen: RadioButton ?= null

    //creates a list of questions from question class
    //userAns is an array of what the user chose as the answer
    lateinit var questionStr : TextView
    lateinit var ChoiceA : RadioButton
    lateinit var ChoiceB : RadioButton
    lateinit var ChoiceC : RadioButton
    lateinit var ChoiceD : RadioButton
    lateinit var ChoiceE : RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val prev = findViewById<Button>(R.id.prev)
        val next = findViewById<Button>(R.id.next)
        val submit = findViewById<Button>(R.id.submit)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        questionStr = findViewById(R.id.question)
        ChoiceA = findViewById(R.id.choiceA)
        ChoiceB = findViewById(R.id.choiceB)
        ChoiceC = findViewById(R.id.choiceC)
        ChoiceD = findViewById(R.id.choiceD)
        ChoiceE = findViewById(R.id.choiceE)

        var intent = intent
        var dummyvar : Int = 0
        when(intent.getIntExtra("Category",0)){
            0 -> {dummyvar = 0}
            1 -> dummyvar = 1
            2 -> dummyvar = 2
            3 -> dummyvar = 3
            4 -> dummyvar = 4
            5 -> dummyvar = 5
            6 -> dummyvar = 6
            7 -> dummyvar = 7
            8 -> dummyvar = 8
            9 -> dummyvar = 9
        }

        prev.setOnClickListener{
            if(questionNumber - 1 >= 0) {
                questionNumber--
                val prevQ: Question = questionsArr[questionNumber]
                changeQText(prevQ)
            }
            if(submit.visibility == View.VISIBLE){
                submit.visibility = View.GONE
            }
            if(questionNumber == 0){
                prev.visibility = View.GONE
            }
        }

        next.setOnClickListener{
            chosen = radioGroup.findViewById(radioGroup.checkedRadioButtonId)
            userAns[questionNumber] = radioGroup.indexOfChild(chosen)

            if(questionNumber + 1 < 10) {
                questionNumber++
                val nextQ: Question = questionsArr[questionNumber]
                changeQText(nextQ)
            }
            if(prev.visibility == View.GONE){
                prev.visibility = View.VISIBLE
            }
            if(questionNumber == 9) {
                next.visibility = View.GONE
                submit.visibility = View.VISIBLE
            }
        }
        submit.setOnClickListener{
            for(i in questionsArr.indices){
                if(questionsArr[i].correctAnswer == userAns[i])
                    score++
            }
            val intent = Intent(this@Questions,Result::class.java)
            intent.putExtra("Score",score)
            startActivity(intent)
        }
    }

    fun changeQText(Q: Question){
        questionStr.text = Q.questionStr
        choiceA.text = Q.choiceA
        choiceB.text = Q.choiceB
        choiceC.text = Q.choiceC
        choiceD.text = Q.choiceD
        choiceE.text = Q.choiceE
    }
}
