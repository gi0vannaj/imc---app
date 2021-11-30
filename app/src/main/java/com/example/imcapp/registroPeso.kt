package com.example.imcapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.imcapp.utils.transformarData
import java.time.LocalDate




class registroPeso : AppCompatActivity() {

    lateinit var spiner: Spinner
    lateinit var novoPeso : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro_peso)
        supportActionBar!!.hide()

        var buttonRegistrar : Button = findViewById(R.id.registrar_peso)

        var dataAtual : TextView = findViewById(R.id.data_pesagem)
        dataAtual.text = transformarData(LocalDate.now().toString())

        novoPeso= findViewById(R.id.novo_peso)
        spiner=findViewById(R.id.nivel_ativ)

       
    }





}