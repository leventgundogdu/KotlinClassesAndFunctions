package com.leventgundogdu.classesandfunctions

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //OnCreate'den once bir tanim yapilmaz, yapilirsa uygulama çöker. Uygulama, lateinit var'ı tanımlamazsan da çöker.
    private lateinit var myTextView : TextView
    private lateinit var myButton : Button
    private lateinit var nameText : EditText
    private lateinit var ageText : EditText
    private lateinit var jobText : EditText

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
        nameText = findViewById(R.id.nameText)
        ageText = findViewById(R.id.ageText)
        jobText = findViewById(R.id.jobText)

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

        val homer = Simpson("Homer", 50, "Nuclear")

        homer.setHeight(50)

//        homer.name = "Homer Simpson"
//        homer.age = 50
//        homer.job = "Nuclear"

        println(homer.name)

        //Nullability (?)

        var myString : String? = null
        myString = "test"

        println(myString)

        var myAge : Int? = null
        //myAge = 50
        // ? : This is null, !! : I am certain that this is NOT null.
        // !! kullanırken iki kere düşünülmelidir.

        //1) !!
        //println(myAge!! * 10)

        //2) Safe call
        println(myAge?.minus(10)) //Bu fonksiyon uygulamayı çökertmeden null verir.

        //3) If (Easiest)
        if (myAge != null) {
            println(myAge.minus(10))
        } else {
            println("myAge is null")
        }

        //4) Elvis Operator (?:) : Soldaki değer null değil ise onu yazdır, null ise sağdaki değeri yazdır.
        println(myAge?.minus(10) ?: -10)

        //5) Eğer myAge'in değeri var ise fonksiyondaki it, onun değerini alır. myAge null ise fonksiyon hiç çalışmaz. If yöntemine benzer.
        myAge?.let {
            println(it * 10)
        }




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
        //Scope
        val name = nameText.text.toString()
        val age = ageText.text.toString().toIntOrNull()
        val job = jobText.text.toString()

        if (age != null) {
            val simpson = Simpson(name, age, job)
            myTextView.text = "Name: ${simpson.name}, Age: ${simpson.age}, Job: ${simpson.job}"

        } else {
            myTextView.text = "ENTER YOUR AGE!"

        }



    }





}