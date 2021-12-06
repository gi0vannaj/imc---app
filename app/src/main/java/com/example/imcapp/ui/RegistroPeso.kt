package com.example.imcapp.ui

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.imcapp.R
import com.example.imcapp.utils.transformarData
import java.time.LocalDate




class RegistroPeso : AppCompatActivity() {

    lateinit var spinerAtivdades: Spinner
    lateinit var novoPeso : EditText
    lateinit var  buttonRegistroPeso: Button
    lateinit var  editNovoPeso: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro_peso)
        supportActionBar!!.hide()

         buttonRegistroPeso=findViewById(R.id.registrar_peso)
        editNovoPeso=findViewById(R.id.novo_peso)

        var dataAtual : TextView = findViewById(R.id.data_pesagem)
        dataAtual.text = transformarData(LocalDate.now().toString())


        spinerAtivdades = findViewById(R.id.nivel_ativ)

        buttonRegistroPeso.setOnClickListener{
            gravarPeso()
        }

       
    }

    private fun gravarPeso() {
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        val editor = arquivo.edit()

        // obter os daods ja inseridos
        val peso = arquivo.getString("peso", "")
        val dataPesagem = arquivo.getString("data_peagem", "")

        editor.putString("data_pesagem","$dataPesagem;${LocalDate.now()}")
        editor.putString("peso", "$peso; ${editNovoPeso.text}")
        editor.putInt("nivel_atividade", spinerAtivdades.selectedItemPosition)
        editor.commit()
    }


}