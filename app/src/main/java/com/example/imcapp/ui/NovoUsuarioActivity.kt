package com.example.imcapp.ui

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.example.imcapp.R
import java.util.*

class NovoUsuarioActivity : AppCompatActivity() {

    lateinit var editNome: EditText
    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var editProfissao: EditText
    lateinit var editAltura: EditText
    lateinit var editDataNascimento: EditText
    lateinit var radioFeminino: RadioButton
    lateinit var radioMasculino: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_usuario)

        editNome = findViewById(R.id.edit_nome)
        editEmail = findViewById(R.id.edit_email)
        editSenha = findViewById(R.id.edit_senha)
        editProfissao = findViewById(R.id.edit_profissao)
        editAltura = findViewById(R.id.edit_altura)
        editDataNascimento = findViewById(R.id.edit_data_nascimento)
        radioFeminino = findViewById(R.id.radio_feminino)
        radioMasculino= findViewById(R.id.radio_masculino)


        supportActionBar!!.title = "Nova conta"

        //criar um calendario
        //obter a data atual (de hoje) atraves da classe abaixo
        val calendario = Calendar.getInstance()
        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        val mes = calendario.get(Calendar.MONTH)
        val ano = calendario.get(Calendar.YEAR)

        //colocar um listener de click no editText Data de nascimento para abrir o calendario(DatePicker)
        editDataNascimento.setOnClickListener{
            criarDatePicker(dia, ano, mes)
        }


    }

    private fun criarDatePicker(dia: Int, ano: Int, mes: Int) {
        val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, _ano, _mes, _dia ->
            var mesReal = _mes + 1

            var diaString = "$_dia"

            var mesString = "$mesReal"

            if (mesReal < 10) {
                mesString = "0$mesReal"
            }

            if (dia < 10) {
                diaString = "0$_dia"
            }


            Log.i("xxxx", "$diaString/$mesString/$_ano")
            editDataNascimento.setText("$diaString/$mesString/$_ano")
        }, ano, mes, dia)

        datePicker.show()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(validarCampos()){
            //gravar os dados no sharedPreferences

             //Criando um arquivo xml chamado "usuario"
                 //se o arquivo ja existir ele
            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
            val editor = arquivo.edit()

            editor.putString("email", editEmail.text.toString())
            editor.putString("senha", editSenha.text.toString())
            editor.putString("nome", editNome.text.toString())
            editor.putString("profissao", editProfissao.text.toString())
            editor.putFloat("altura", editAltura.text.toString().toFloat())
            editor.putString("nascimento",editDataNascimento.text.toString())
            editor.putString("sexo",if(radioMasculino.isChecked) "M" else "F")
            editor.apply()

            Toast.makeText(this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show()
            finish()
        }else{
            //grava nada
        }

        return true
    }

    private fun validarCampos(): Boolean{

        var valido = true

        if(editEmail.text.isEmpty()){
            editEmail.error = "Email é obrigatorio"
            valido = false
        }

        if(editSenha.text.isEmpty()){
            editSenha.error = "Senha é obrigatorio"
            valido = false
        }
        if(editNome.text.isEmpty()){
            editNome.error = "Nome é obrigatorio"
            valido = false
        }
        if(editAltura.text.isEmpty()){
            editAltura.error = "Altura é obrigatorio"
            valido = false
        }
        if(editDataNascimento.text.isEmpty()){
            editDataNascimento.error = "A data de nascimento é obrigatorio"
            valido = false
        }
        if(!radioFeminino.isChecked && !radioMasculino.isChecked){
            radioMasculino.error = "Genero é obrigatorio"
            valido = false
        }


        return valido
    }

    //criar menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_imc_app, menu)
        return true
    }
}