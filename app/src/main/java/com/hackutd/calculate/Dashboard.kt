package com.hackutd.calculate

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import org.eazegraph.lib.charts.PieChart

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val btnCall: LinearLayout = findViewById(R.id.btnCall)
        val btnPR: Button = findViewById(R.id.btnPR)
        val btnEH: Button = findViewById(R.id.btnEH)
        val btnRH: Button = findViewById(R.id.btnRH)
        val btnLCR: Button = findViewById(R.id.btnLCR)
        val btnLR: Button = findViewById(R.id.btnLR)

        btnCall.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:800-799-7233"))
            startActivity(dialIntent)
        }

        btnPR.setOnClickListener {
            startActivity(Intent(this, PersonalLoans::class.java))
        }

        btnEH.setOnClickListener {
            startActivity(Intent(this, EmploymentHelp::class.java))
        }

        btnRH.setOnClickListener {
            startActivity(Intent(this, ResumeHelp::class.java))
        }

        btnLCR.setOnClickListener {
            startActivity(Intent(this, LGBTCenterResources::class.java))
        }

        btnLR.setOnClickListener {
            startActivity(Intent(this, LegalResources::class.java))
        }

        val setUpSavingsButton : Button = findViewById(R.id.setupSavingsButton)
        val creditScoreButton : ImageButton = findViewById(R.id.creditScore)
        val pieChart : PieChart = findViewById(R.id.pieChart)

        btnCall.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:800-799-7233"))
            startActivity(dialIntent)
        }

        btnPR.setOnClickListener {
            startActivity(Intent(this, PersonalLoans::class.java))
        }

        btnEH.setOnClickListener {
            startActivity(Intent(this, EmploymentHelp::class.java))
        }

        btnRH.setOnClickListener {
            startActivity(Intent(this, ResumeHelp::class.java))
        }

        btnLCR.setOnClickListener {
            startActivity(Intent(this, LGBTCenterResources::class.java))
        }

        btnLR.setOnClickListener {
            startActivity(Intent(this, LegalResources::class.java))
        }

        creditScoreButton.setOnClickListener {
            val webIntent: Intent = Uri.parse("https://www.fidelity.com/learning-center/personal-finance/improving-credit").let { webpage ->
                Intent(Intent.ACTION_VIEW, webpage)
            }
            startActivity(webIntent)
        }

        pieChart.setOnClickListener{
            val switchActivityIntent = Intent(this, SavingsGoals::class.java)
            startActivity(switchActivityIntent)
        }
    }
}
