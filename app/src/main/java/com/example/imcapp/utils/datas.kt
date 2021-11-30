package com.example.imcapp.utils

import android.util.Log
import java.time.LocalDate
import java.time.Period

fun calcularIdade(dataNascimento :String): Int {


    //obter a data atual
    val hoje = LocalDate.now()

    //converter a dataNascimento que é string para localdate
    val data = dataNascimento.split("-")
    Log.i("xpto",data.get(0))
    Log.i("xpto",data.get(1))
    Log.i("xpto",data.get(2))

    val nascimento = LocalDate.of(
        data.get(2).toInt(),
        data.get(1).toInt(),
        data.get(0).toInt())

    //calcular o intervalo entre a data atual(hoje) e a data de nascimento

    val idade = Period.between(nascimento, hoje).years

    Log.i("xpto", idade.toString())


    return 0


}
fun transformarData(dataFormatoAntigo:String):String{
    val data = dataFormatoAntigo.split("/")

    val dataAtual = data[2] + "/" + data[1] +"/" +  data[0]
    return dataAtual

}