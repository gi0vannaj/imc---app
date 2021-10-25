package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        val buttonEntrar = findViewById<Button>(R.id.button_entar)
        val buttonNovaConta= findViewById<Button>(R.id.button_nova_conta)

        buttonEntrar.setOnClickListener{
            val abrirDashBoard = Intent(this, DashBordActivity::class.java)
            startActivity(abrirDashBoard)

        }

        buttonNovaConta.setOnClickListener{
            val abrirNovaConta= Intent(this,NovoUsuarioActivity::class.java)
            startActivity(abrirNovaConta)
        }

    }
}