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
    /*
    * THIS ACTIVITY HANDLES 10 QUESTIONS
    * BASIC OUTLINE: TEXT VIEW (FOR STRING OF THE QUESTION), 5 RADIO BUTTONS (a-e). NEXT, PREVIOUS, SUBMIT BUTTONS
    * THE BUTTONS' VISIBILITY ARE ALTERED SOMETIMES E.G: PREVIOUS IS GONE ON THE FIRST Q
    * questionsArr IS AN ARRAY OF QUESTIONS, i MADE A KOTLIN CLASS CALLED QUESTION, CHECK IT OUT
    *
    *
    *
    *
    * VERY IMMPORTANT
    * THE WHEN PART (STARTING ON LIKE LINE 60) IS FOR QUESTION CHOOSING
    * IN THE LAST ACTIVITY I SAID THE NUMBER CORRESPONDS TO THE TOPIC
    * SO IF IT IS 0, THEN YOU SHOULD PICK QUESTIONS THAT ARE ARITHMATIC STUFF
    * since i didnt do the data part im not sure how to integrate this into the code...
    * make sure it is random!
    *
    *
    *
    * THE userAns is an array that holds the user answers (as numbers, 1 = a...)
    *
    *
    * WHAT WE NEED
    * i think you need to uncheck when it is checked and the user clicked next. not sure how to do that
    * also when the user solved a problem, and goes back, there should be a textbox saying : oh you picked A
    * like that would be nice
    * */
    private var questionNumber: Int = 0        //questionNumber keeps track of current Q, 0 is starting
    private var score: Int = 0
    private var questionsArr = Array(10, {i -> Question("","", "","","","","1")})
    private var userAns = Array(10,{i -> ""})
    var chosen: RadioButton ?= null
    var dataBaseHelper: DataBaseHelper = DataBaseHelper(this)
    var categoryNum = 0

    //creates a list of questions from question class
    //userAns is an array of what the user chose as the answer
    private lateinit var questionStr : TextView
    private lateinit var currentAns : TextView
    private lateinit var ChoiceA : RadioButton
    private lateinit var ChoiceB : RadioButton
    private lateinit var ChoiceC : RadioButton
    private lateinit var ChoiceD : RadioButton
    private lateinit var ChoiceE : RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val prev = findViewById<Button>(R.id.prev)
        val next = findViewById<Button>(R.id.next)
        val submit = findViewById<Button>(R.id.submit)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        questionStr = findViewById(R.id.question)
        currentAns = findViewById(R.id.CurrentAns)
        ChoiceA = findViewById(R.id.choiceA)
        ChoiceB = findViewById(R.id.choiceB)
        ChoiceC = findViewById(R.id.choiceC)
        ChoiceD = findViewById(R.id.choiceD)
        ChoiceE = findViewById(R.id.choiceE)

        var intent = intent
<<<<<<< HEAD
        when(intent.getIntExtra("Category",0)){
=======
        var dummyvar : Int = 0
        categoryNum = intent.getIntExtra("Category", 0)
        when(categoryNum){
>>>>>>> 76c090862d68857d998c2a23a9c5b240234a2a2c
            0 -> questionsArr = dataBaseHelper.getQuestions(0)
            1 -> questionsArr = dataBaseHelper.getQuestions(1)
            2 -> questionsArr = dataBaseHelper.getQuestions(2)
            3 -> questionsArr = dataBaseHelper.getQuestions(3)
            4 -> questionsArr = dataBaseHelper.getQuestions(4)
            5 -> questionsArr = dataBaseHelper.getQuestions(5)
            6 -> questionsArr = dataBaseHelper.getQuestions(6)
            7 -> questionsArr = dataBaseHelper.getQuestions(7)
            8 -> questionsArr = dataBaseHelper.getQuestions(8)
            9 -> questionsArr = dataBaseHelper.getQuestions(9)
        }

        changeQText(questionsArr[0])
        prev.setOnClickListener{
            if(questionNumber - 1 >= 0) {
                questionNumber--
                val prevQ: Question = questionsArr[questionNumber]
                changeQText(prevQ)
            }
            if(submit.visibility == View.VISIBLE){
                submit.visibility = View.GONE
            }
            if(next.visibility == View.GONE){
                next.visibility = View.VISIBLE
            }
            if(questionNumber == 0){
                prev.visibility = View.GONE
            }
        }

        next.setOnClickListener{
            chosen = radioGroup.findViewById(radioGroup.checkedRadioButtonId)
            if (chosen != null)
                userAns[questionNumber] = chosen!!.text.toString()//.substring(3)
            radioGroup.clearCheck()

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
            chosen = radioGroup.findViewById(radioGroup.checkedRadioButtonId)
            if (chosen != null)
                userAns[questionNumber] = chosen!!.text.toString()
            radioGroup.clearCheck()
            for(i in questionsArr.indices){
                if(questionsArr[i].correctAnswer == userAns[i]) {
                    score++
                }
            }
            val intent = Intent(this@Questions,Result::class.java)
            intent.putExtra("Score",score)
            intent.putExtra("Category", categoryNum)
            startActivity(intent)
        }
    }

    private fun changeQText(Q: Question){
        questionStr.text = "Q" + (questionNumber + 1) + ") " + Q.questionStr
        choiceA.text = Q.choiceA
        choiceB.text = Q.choiceB
        choiceC.text = Q.choiceC
        choiceD.text = Q.choiceD
        choiceE.text = Q.choiceE
        currentAns.text = "Your current answer is " + userAns[questionNumber]
    }
}
