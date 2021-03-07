package br.com.alura.bytebank.tests

import br.com.alura.bytebank.exception.SaldoInsuficienteException
import java.lang.Exception
import java.lang.NumberFormatException

fun main() {
    println("inicio main")


    // val entrada: String = "1,9" assim o resultado final será o valor invalido

    val entrada: String = "1.9"

    val valorRecebido: Double? = try {//sinal de ? está informando que essa expressão vai retornar um Double mas pode retornar um null
        entrada.toDouble()             //o try é uma expressão
    }catch (e: SaldoInsuficienteException) {
        println("Problema na Conversao")
        e.printStackTrace()
        throw e;
        null
    } catch (e: Exception){
        e.printStackTrace();
        throw e;
    }

    val valorComTaxa: Double? = if(valorRecebido != null){//o if é uma expressão assim como o try
         valorRecebido + 0.1                              //isso se chama if expression
    } else {
         null;
    }

    if(valorRecebido != null){ //o if é uma expressão
        println("Valor recebido: $valorRecebido")
    }else {
        println("valor invalido")
    }

    try {
        10/0
    } catch (e: ArithmeticException) {
        throw e;
    }
    funcao1()
    println("fim do main")
}

fun funcao1() {
    println("inicio funcao1")
    funcao2()
    println("fim funcao1")
}

fun funcao2() {
    println("inicio funcao2")
    for (i in 1..5){
        println(i)
    }
    println("fim funcao2")
}
