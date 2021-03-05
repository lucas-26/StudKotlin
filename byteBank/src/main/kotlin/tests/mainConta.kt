package tests

import models.ContaCorrente
import models.ContaPoupanca

fun main() {
    println("Bem vindo ao byte Bank");

    val contaCorrente = ContaCorrente(titular = "lucas", numero = 1000)

    val contaPoupanca = ContaPoupanca(titular = "Lucas", numero = 2000)


}