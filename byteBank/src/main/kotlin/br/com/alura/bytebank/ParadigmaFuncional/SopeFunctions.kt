package br.com.alura.bytebank.ParadigmaFuncional

import br.com.alura.bytebank.models.Cliente
import br.com.alura.bytebank.models.ContaPoupanca
import br.com.alura.bytebank.models.Endereco

fun main() {
     with(Endereco()) {
        logradouro = "rua Vergueiro"
        numero = 6564
        bairro = "Vila Mariana"
        cidade = "São Paulo"
        estado = "SP"
        cep = "08475-847"
        complemento = "Apartamento"
        enderecoCompleto()
    }.let { enderecoCompleto: String ->
        println(enderecoCompleto)
    }

    val taxaAnual = 0.05
    val taxaMensal = taxaAnual / 12

    val contaPoupanca = ContaPoupanca(
        Cliente(nome = "Lucas", cpf = "111.111.111-11" ,senha = 1234), numero = 10000)

        contaPoupanca.run {
            depositar(1000.0)
            saldo * taxaMensal
        }.let {
            rendimentoMensal ->
            println("Rendimento mensal:  $rendimentoMensal")
        }

    val rendimentoAnual = run {
        var saldo = contaPoupanca.saldo
        repeat(12) { indice ->
        saldo += saldo * taxaMensal

        }
    }
    println("Rendimento anual: $rendimentoAnual")
}

