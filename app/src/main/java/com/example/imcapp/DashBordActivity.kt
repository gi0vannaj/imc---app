package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DashBordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_bord)

        supportActionBar!!.hide()
    }

}