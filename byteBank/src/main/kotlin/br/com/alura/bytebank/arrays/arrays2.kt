package br.com.alura.bytebank.tests

fun main() {
    val valor:DoubleArray = doubleArrayOf(1500.02, 2300.40, 5000.0, 8000.0, 10000.0)

    val aumento = 1.1
//    var indice: Int = 0
//    for (valorSalario in valor){
//        valor[indice] = valorSalario * aumento
//        indice++
//    }

    println(valor.contentToString())

    for(indice1 in valor.indices ){//for que vai conter os indices das posições dos valores que o array contem
        valor[indice1] = valor[indice1] * aumento
    }
    println(valor.contentToString())
    
    valor.forEachIndexed { index, salario -> //esse foreach recebe dois paramentros, nesse caso o indice e o salario
        valor[index] = salario * aumento
    }
    println(valor.contentToString())
}