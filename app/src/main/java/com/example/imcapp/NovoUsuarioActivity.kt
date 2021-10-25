package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton

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
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(validarCampos()){
            //gravar od dados
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

        return valido
    }

    //criar menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_imc_app, menu)
        return true
    }
}