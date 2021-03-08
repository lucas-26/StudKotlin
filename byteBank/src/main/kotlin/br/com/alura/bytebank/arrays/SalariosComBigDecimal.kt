package br.com.alura.bytebank.tests

import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val aumento: BigDecimal = "1.1".toBigDecimal()
    val myar = bigDecimalArrayOf("1500.55","2000.00", "3000.00","11000.00")
    println(myar.contentToString())

    val salariosComAumento = myar.map {   //A função map mapeia um valor para o outro nesse caso, ele vai
            salario -> calculaAumentoRelativo(salario, aumento) }// pegar um salario e para cada salário ele vai fazer o salario vezes o aumento e atribuir para a variavél salario e o set scale é para mostrar duas casas depois da virgula
        .toTypedArray()                   //A função map retorna uma lista, por isso estamos usando o toarray no final

    println(salariosComAumento.contentToString())

    val gastoInicial = salariosComAumento.somatorio()
    println(gastoInicial)

    val meses = 6.toBigDecimal()
    val gastoTotal = salariosComAumento.fold(gastoInicial) { acumulador, salario ->
        acumulador + (salario * meses).setScale(2, RoundingMode.UP)
    }
    println(gastoTotal)

    val media = salariosComAumento.sorted().takeLast(3).toTypedArray().media()
    println(media)
}

private fun calculaAumentoRelativo(salario: BigDecimal, aumento: BigDecimal) =
    if (salario < "5000".toBigDecimal()) {
        salario + "500".toBigDecimal()
    } else {
        (salario * aumento).setScale(2, RoundingMode.UP)
    }
