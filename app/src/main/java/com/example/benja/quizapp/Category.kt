package com.example.benja.quizapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Category : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val arith = findViewById<TextView>(R.id.cate1)
        val loop = findViewById<TextView>(R.id.cate2)
        val arr = findViewById<TextView>(R.id.cate3)
        val arrlst = findViewById<TextView>(R.id.cate4)
        val str = findViewById<TextView>(R.id.cate5)
        val inherit = findViewById<TextView>(R.id.cate6)
        val methods = findViewById<TextView>(R.id.cate7)
        val recursion = findViewById<TextView>(R.id.cate8)
        val efficiency = findViewById<TextView>(R.id.cate9)
        val searching = findViewById<TextView>(R.id.cate10)

        arith.setOnClickListener{
            val intent = Intent(this@Category,Questions::class.java)
            intent.putExtra("Category", 0)
            startActivity(intent)
        }
        loop.setOnClickListener{
            val intent = Intent(this@Category,Questions::class.java)
            intent.putExtra("Category", 1)
            startActivity(intent)
        }
        arr.setOnClickListener{
            val intent = Intent(this@Category,Questions::class.java)
            intent.putExtra("Category",2)
            startActivity(intent)
        }
        arrlst.setOnClickListener{
            val intent = Intent(this@Category,Questions::class.java)
            intent.putExtra("Category",3)
            startActivity(intent)
        }
        str.setOnClickListener{
            val intent = Intent(this@Category,Questions::class.java)
            intent.putExtra("Category",4)
        }
        inherit.setOnClickListener{
            val intent = Intent(this@Category,Questions::class.java)
            intent.putExtra("Category",5)
            startActivity(intent)
        }
        methods.setOnClickListener{
            val intent = Intent(this@Category,Questions::class.java)
            intent.putExtra("Category",6)
            startActivity(intent)
        }
        recursion.setOnClickListener{
            val intent = Intent(this@Category,Questions::class.java)
            intent.putExtra("Category",7)
            startActivity(intent)
        }
        efficiency.setOnClickListener{
            val intent = Intent(this@Category,Questions::class.java)
            intent.putExtra("Category",8)
            startActivity(intent)
        }
        searching.setOnClickListener{
            val intent = Intent(this@Category,Questions::class.java)
            intent.putExtra("Category",9)
            startActivity(intent)
        }
    }
}
