package com.leventgundogdu.classesandfunctions

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //OnCreate'den once bir tanim yapilmaz, yapilirsa uygulama çöker. Uygulama, lateinit var'ı tanımlamazsan da çöker.
    lateinit var myTextView : TextView
    lateinit var myButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        myTextView = findViewById(R.id.textView)
        myButton = findViewById(R.id.button)

//        myButton.setOnClickListener {
//            myTextView.text = "button clicked 2"
//        }

        //Functions: 1) code block, reusable 2) input 3) output - return

        test()
        mySum(10, 15) //Fonksiyon tipi Unit ise bir deger dondurmez

        val sumResult = mySum(40, 35)
        val result = myMultiply(10, 20)

        println(sumResult)
        println(result)

        //Class

        val homer = Simpson()
        homer.name = "Homer Simpson"
        homer.age = 50
        homer.job = "Nuclear"

        println(homer.name)

    }

    fun test() {
//        println("test function")
    }

    fun mySum(a: Int, b: Int) {

    }

    fun myMultiply(x: Int, y: Int) : Int {
//        println(x * y)
        val result = x * y

        myTextView.text = "Result: ${result}"

        return result //return'den sonra kod yazilmaz cunku kod, return'den sonra okunmaz
    }

    fun buttonClicked(view : View) {
        myTextView.text = "Button Clicked"
    }





}