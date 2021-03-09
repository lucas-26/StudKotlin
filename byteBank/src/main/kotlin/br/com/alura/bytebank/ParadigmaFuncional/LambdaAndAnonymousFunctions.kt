package br.com.alura.bytebank.ParadigmaFuncional

fun main() {

    val minhaFuncaoLambda: () -> Unit = {
        println("Executando o lambda")
    }

    val minhaFuncaoAnonima: () -> Unit = fun () {
        println("Executando a funcao anonima")
    }
}