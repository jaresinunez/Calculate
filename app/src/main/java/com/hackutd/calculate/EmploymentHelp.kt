package com.hackutd.calculate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hack.hacksa.Company
import com.hack.hacksa.CompanyAdapter

class EmploymentHelp : AppCompatActivity() {
    var companyNames = mutableListOf("Taco Cabana", "Applebee's", "Chili's", "Cheddars", "Dutchbros", "Whataburger", "McDonald's")
    var companyRankings = mutableListOf(4.4, 4.2, 4.5, 4.8, 4.9, 3.8, 4.2)
    var companyRoleDescriptions = mutableListOf("Dishwasher", "Hostess", "Bartender", "Hostess", "Linebusser", "Drive-Thru Attendant", "Cashier")
    var companyHours = mutableListOf(5.0, 6.5, 4.0, 8.5, 3.75, 5.45, 6.0)
    var companyPay = mutableListOf("$12/hr", "$11/hr", "$10.50/hr", "11/hr", "$8.50/hr", "$11.50/hr", "$12.50/hr")
    var drawables = intArrayOf(
        R.drawable.taco_cabana,
        R.drawable.applebees,
        R.drawable.chilies,
        R.drawable.cheddars,
        R.drawable.dutch_bros,
        R.drawable.whataburger,
        R.drawable.mcdonalds
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eh)

        val recyclerView = findViewById<RecyclerView>(R.id.availableJobs)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<Company>()

        for (i in 0..6) {
            data.add(Company(drawables[i], companyNames[i], companyRankings[i], companyRoleDescriptions[i], companyHours[i] as Double, companyPay[i]))
        }

        val adapter = CompanyAdapter(data)
        recyclerView.adapter = adapter

    }
}