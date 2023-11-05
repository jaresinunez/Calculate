package com.hackutd.calculate

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val btnCall: Button = findViewById(R.id.btnCall)
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
    }
}
