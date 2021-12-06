package com.example.imcapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.imcapp.R

class DashBordActivity : AppCompatActivity() {

    lateinit var tvNome: TextView
    lateinit var tvProfissao: TextView
    lateinit var  tvAltura: TextView
    lateinit var  cardPesarAgora: CardView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_bord)

        tvNome = findViewById(R.id.tv_dash_nome)
        tvProfissao = findViewById(R.id.tv_dash_profissao)
        tvAltura = findViewById(R.id.tv_dash_altura)
        cardPesarAgora = findViewById(R.id.button_pesar_agora)

        cardPesarAgora.setOnClickListener {
            val registrarPeso = Intent(this, RegistroPeso::class.java)
            startActivity(registrarPeso)
        }



        preencherDashboard()

        supportActionBar!!.hide()
    }

    private fun preencherDashboard(){
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        tvNome.text = arquivo.getString("nome","")
        tvProfissao.text = arquivo.getString("profissao","")
        tvAltura.text = arquivo.getFloat("altura", 0.0f). toString()



    }





}