package com.example.summerpractice

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var height: EditText
    private lateinit var weight: EditText
    private lateinit var age: EditText

    private var result = 0

    private lateinit var clickButton: Button

    private val bottomLine = 0
    private val upperLine1 = 250
    private val upperLine2 = 50
    private val upperLine3 = 150


    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        height = findViewById(R.id.height)
        weight = findViewById(R.id.weight)
        age = findViewById(R.id.age)
        val stringResult = findViewById<TextView>(R.id.result)

        var nameLength = name.length()

        fun correctData(nameLength : Int, myHeight : Int, myWeight : Double, myAge : Int): Boolean {
            return nameLength < upperLine2 && myHeight in bottomLine..upperLine1 && myWeight in bottomLine.toDouble()..upperLine1.toDouble() && myAge in bottomLine..upperLine3
        }

        clickButton = findViewById(R.id.button)
        clickButton?.setOnClickListener {
            if (name.text.isEmpty() || height.text.isEmpty() || weight.text.isEmpty() || age.text.isEmpty()) {
                stringResult.text = getString(R.string.data_entered_incorrectly)
            } else {
                val myHeight = height.text.toString().toInt()
                val myWeight = weight.text.toString().toDouble()
                val myAge = age.text.toString().toInt()

                if (correctData(nameLength, myHeight, myWeight, myAge)) {
                    result = (myWeight * 10).roundToInt() + (myHeight * 6.25).roundToInt() - myAge * 5 - 161
                    stringResult.text = "Your ideal calorie count: $result"
                } else {
                    stringResult.text = getString(R.string.data_entered_incorrectly)
                }
            }
        }
    }
}