package com.hackutd.calculate

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.eazegraph.lib.charts.PieChart
import org.eazegraph.lib.models.PieModel


class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val pieChart : PieChart = findViewById(R.id.pieChart)

        pieChart.addPieSlice(
            PieModel(
                "R", 60F,
                Color.parseColor("#21D375")
            )
        )
        pieChart.addPieSlice(
            PieModel(
                "Python", 50F,
                Color.parseColor("#FFFFFFFF")
            )
        )


        pieChart.startAnimation()



    }
}