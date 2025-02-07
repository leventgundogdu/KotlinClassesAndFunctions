package com.leventgundogdu.classesandfunctions

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Functions: 1) code block, reusable 2) input 3) output - return

//        println("Hello Kotlin")
        test()
        mySum(10, 15) //Fonksiyon tipi Unit ise bir deger dondurmez

        val sumResult = mySum(40, 35)
        val result = myMultiply(10, 20)

        println(sumResult)
        println(result)

    }

    fun test() {
//        println("test function")
    }

    fun mySum(a: Int, b: Int) {

    }

    fun myMultiply(x: Int, y: Int) : Int {
//        println(x * y)
        val result = x * y

        val myTextView = findViewById<TextView>(R.id.textView)
        myTextView.text = "Result: $result"

        return result //return'den sonra kod yazilmaz cunku kod, return'den sonra okunmaz
    }



}