package br.com.alura.bytebank.models

class ContaPoupanca(titular: Cliente, numero: Int)
    : Conta(
            titular = titular,
            numero = numero,
            ){

    override fun depositar(valor: Double): Double {
        TODO("Not yet implemented")
    }

    override fun sacar(valor: Double): Double {
        TODO("Not yet implemented")
    }

    override fun transferencia(destino: Conta, valor: Double): Boolean {
        TODO("Not yet implemented")
    }

}