package com.hackutd.calculate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {
    var startedStatement = false
    var selected1 by Delegates.notNull<Int>()
    var selected2 by Delegates.notNull<Int>()
    var solution by Delegates.notNull<Int>()
    lateinit var selection : String
    var code = ""
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
        val clear : Button = findViewById(R.id.clear)

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
            code += "1"
        }

        two.setOnClickListener{
            if (!startedStatement) {
                selected1 = 2
                startedStatement = true
                solutionField.text = selected1.toString()
            } else {
                selected2 = 2
                solutionField.text = selected2.toString()
            }
            code += "2"
        }

        three.setOnClickListener{
            if (!startedStatement) {
                selected1 = 3
                startedStatement = true
                solutionField.text = selected1.toString()
            } else {
                selected2 = 3
                solutionField.text = selected2.toString()
            }
            code += "3"
        }

        four.setOnClickListener{
            if (!startedStatement) {
                selected1 = 4
                startedStatement = true
                solutionField.text = selected1.toString()
            } else {
                selected2 = 4
                solutionField.text = selected2.toString()
            }
            code += "4"
        }

        five.setOnClickListener{
            if (!startedStatement) {
                selected1 = 5
                startedStatement = true
                solutionField.text = selected1.toString()
            } else {
                selected2 = 5
                solutionField.text = selected2.toString()
            }
            code += "5"
        }

        six.setOnClickListener{
            if (!startedStatement) {
                selected1 = 6
                startedStatement = true
                solutionField.text = selected1.toString()
            } else {
                selected2 = 6
                solutionField.text = selected2.toString()
            }
            code += "6"
        }

        seven.setOnClickListener{
            if (!startedStatement) {
                selected1 = 7
                startedStatement = true
                solutionField.text = selected1.toString()
            } else {
                selected2 = 7
                solutionField.text = selected2.toString()
            }
            code += "7"
        }

        eight.setOnClickListener{
            if (!startedStatement) {
                selected1 = 8
                startedStatement = true
                solutionField.text = selected1.toString()
            } else {
                selected2 = 8
                solutionField.text = selected2.toString()
            }
            code += "8"
        }

        nine.setOnClickListener{
            if (!startedStatement) {
                selected1 = 9
                startedStatement = true
                solutionField.text = selected1.toString()
            } else {
                selected2 = 9
                solutionField.text = selected2.toString()
            }
            code += "9"
        }

        zero.setOnClickListener{
            if (!startedStatement) {
                selected1 = 0
                startedStatement = true
                solutionField.text = selected1.toString()
            } else {
                selected2 = 0
                solutionField.text = selected2.toString()
            }
            code += "0"
        }

        addition.setOnClickListener { selection = "+" }
        subtract.setOnClickListener { selection = "-" }
        multiply.setOnClickListener { selection = "X" }
        divide.setOnClickListener { selection = "/" }

        evaluate.setOnClickListener {
            if (code != "8428") {
                solution = calculate(selected1, selected2, selection)
                if (solution != Int.MAX_VALUE)
                    solutionField.text = solution.toString()
                else
                    solutionField.text = "ERR"
                code = ""
            } else {
                val switchActivityIntent: Intent = Intent(this, Dashboard::class.java)
                startActivity(switchActivityIntent)
                Toast.makeText(this, "CODE MATCH", Toast.LENGTH_LONG).show()
            }
        }

        clear.setOnClickListener {
            solutionField.text = ""
            code = ""
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