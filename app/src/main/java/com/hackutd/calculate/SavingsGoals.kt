package com.hackutd.calculate

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.hackutd.calculate.Globals.CURRENT
import com.hackutd.calculate.Globals.GOAL
import com.hackutd.calculate.Globals.SETUP
import org.eazegraph.lib.charts.PieChart
import org.eazegraph.lib.models.PieModel


class SavingsGoals : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_savings_goals)

        val submitButton: Button = findViewById(R.id.submitGoalsButton)
        val updateButton: Button = findViewById(R.id.updateGoalsButton)
        val learnMore: Button = findViewById(R.id.learnMoreButton)
        val backButton:Button = findViewById(R.id.back)
        val goalField: EditText = findViewById(R.id.goal_field)
        val addField: EditText = findViewById(R.id.current_field)
        val pieChart : PieChart = findViewById(R.id.pieChart)

        if (SETUP){
            findViewById<LinearLayout>(R.id.goalGroup).visibility = View.GONE
            submitButton.visibility = View.GONE
            updateButton.visibility = View.VISIBLE

            pieChart.addPieSlice(
                PieModel(
                    "R", CURRENT,
                    Color.parseColor("#21D375")
                )
            )
            pieChart.addPieSlice(
                PieModel(
                    "Python", GOAL- CURRENT,
                    Color.parseColor("#FFFFFFFF")
                )
            )

            pieChart.startAnimation()
        }


        submitButton.setOnClickListener {
            GOAL = goalField.text.toString().toFloat()
            CURRENT += addField.text.toString().toFloat()

            findViewById<LinearLayout>(R.id.goalGroup).visibility = View.GONE
            submitButton.visibility = View.GONE
            updateButton.visibility = View.VISIBLE
            goalField.text.clear()
            addField.text.clear()

            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)

            pieChart.addPieSlice(
                PieModel(
                    "R", CURRENT,
                    Color.parseColor("#21D375")
                )
            )
            pieChart.addPieSlice(
                PieModel(
                    "Python", GOAL- CURRENT,
                    Color.parseColor("#FFFFFFFF")
                )
            )

            SETUP = true
            pieChart.startAnimation()
        }

        updateButton.setOnClickListener {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)

            pieChart.clearChart()
            CURRENT += addField.text.toString().toFloat()
            pieChart.addPieSlice(
                PieModel(
                    "R", CURRENT,
                    Color.parseColor("#21D375")
                )
            )
            pieChart.addPieSlice(
                PieModel(
                    "Python", GOAL- CURRENT,
                    Color.parseColor("#FFFFFFFF")
                )
            )
            addField.text.clear()
            pieChart.startAnimation()
        }

        learnMore.setOnClickListener {
            val url = "https://www.fidelity.com/spend-save/fidelity-cash-management-account/overview"
            val uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            // Verify that the intent will resolve to an activity
            // Verify that the intent will resolve to an activity
            startActivity(intent)
        }

        backButton.setOnClickListener {
            val refresh = Intent(this, Dashboard::class.java)
            startActivity(refresh) //Start the same Activity
            finish() //finish Activity.
        }
    }
}