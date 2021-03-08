package br.com.alura.bytebank.tests

fun main() {
    val serie:IntRange = 1.rangeTo(10) //criando um range
    for(s in serie){
        println(s)
    }

    val numerosPares = 0..100 step 2 //criando um range de 0 até 100 que vão variar de 2 em 2 exemplo 0 2 4
    for (a in numerosPares){
        println(a)
    }

    val numerosParesUm = 0.until(100) step 2 //criando um range de 0 até 100 que vão variar de 2 em 2 exemplo 0 2 4
    for (b in numerosPares){                    // diferente da função acima a funcao until nao vai incluir o 100
        println(b)
    }

    val numeroParaReverso = 100 downTo 0 step 2//criando um range de 100 até 0 de 2 em 2
    numeroParaReverso.forEach { println(it) }

    val intervalo = 1500.0..500.0
    val tessalario = 4000.0
    if(tessalario in intervalo){ //pode ser usando como verificacao
        println("Está dentro do intervalo")
    } else {
        println("não está dentro do intervalo")
    }

    val alfaberto = "a".."z"
}