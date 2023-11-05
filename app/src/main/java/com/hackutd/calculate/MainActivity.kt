package com.hackutd.calculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    var startedStatement = false
    var selected1 by Delegates.notNull<Int>()
    var selected2 by Delegates.notNull<Int>()
    var solution by Delegates.notNull<Int>()
    lateinit var selection : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val one : Button = findViewById(R.id.one)
        val two : Button = findViewById(R.id.two)
        val three : Button = findViewById(R.id.three)
        val four : Button = findViewById(R.id.four)
        val five : Button = findViewById(R.id.five)
        val six : Button = findViewById(R.id.six)
        val seven : Button = findViewById(R.id.seven)
        val eight : Button = findViewById(R.id.eight)
        val nine : Button = findViewById(R.id.nine)
        val zero : Button = findViewById(R.id.zero)
        val addition : Button = findViewById(R.id.addition)
        val subtract : Button = findViewById(R.id.subtract)
        val divide : Button = findViewById(R.id.divide)
        val multiply : Button = findViewById(R.id.multiply)
        val evaluate : Button = findViewById(R.id.evaluate)

        val solutionField : TextView = findViewById(R.id.solution)

        one.setOnClickListener{
            if (!startedStatement) {
                selected1 = 1
                startedStatement = true
                solutionField.text = selected1.toString()
            } else {
                selected2 = 1
                solutionField.text = selected2.toString()
            }
        }

        addition.setOnClickListener {
            selection = "+"
        }

        evaluate.setOnClickListener {
            solution = calculate(selected1, selected2, selection)
            if (solution.toInt() != Int.MAX_VALUE)
                solutionField.text = solution.toString()
            else
                solutionField.text = "ERR"
        }

    }

    private fun calculate(selected1: Int, selected2: Int, selection: String): Int {
        if (selection == "/"){
            return selected1 / selected2
        } else if (selection == "X"){
            return selected1 * selected2
        } else if (selection == "-"){
            return selected1 - selected2
        } else if (selection == "+"){
            return selected1 + selected2
        } else {
            return Int.MAX_VALUE
        }
    }
}