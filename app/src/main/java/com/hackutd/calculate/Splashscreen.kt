package com.hackutd.calculate

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import java.util.TimerTask


@SuppressLint("CustomSplashScreen")
class Splashscreen : AppCompatActivity() {
    lateinit var timer: Timer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                val intent = Intent(this@Splashscreen, Dashboard::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)
    }
}