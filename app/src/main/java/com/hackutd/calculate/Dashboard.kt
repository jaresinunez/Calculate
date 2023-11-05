package com.hackutd.calculate

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.hackutd.calculate.Globals.CURRENT
import com.hackutd.calculate.Globals.GOAL
import com.hackutd.calculate.Globals.SETUP
import org.eazegraph.lib.charts.PieChart
import org.eazegraph.lib.models.PieModel


class Dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val setUpSavingsButton : Button = findViewById(R.id.setupSavingsButton)
        val pieChart : PieChart = findViewById(R.id.pieChart)

        if (SETUP){
            setUpSavingsButton.visibility = View.GONE
            pieChart.visibility = View.VISIBLE
        }

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

        setUpSavingsButton.setOnClickListener {
            val switchActivityIntent = Intent(this, SavingsGoals::class.java)
            startActivity(switchActivityIntent)

            setUpSavingsButton.visibility = View.GONE
            pieChart.visibility = View.VISIBLE
        }

    }
}