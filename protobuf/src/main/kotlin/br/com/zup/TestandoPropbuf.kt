package br.com.zup

import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {
    val request = FuncionarioRequest.newBuilder() //montando o objeto
        .setNome("Lucas Araujo")
        .setCpf("000.000.000-00")
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addAllEnderecos(FuncionarioRequest.Endereco.newBuilder()
            .setLogradouro("Rua das Andorinhas")
            .setCep("00000-000")
            .setComplemento("Casa 20"))
        .build()
    println(request)

    request.writeTo(FileOutputStream("funcionario-request.bin")) //transformando de um objeto para binario, escrevemos um aquivo binario para mandar na rede

    val request2 = FuncionarioRequest.newBuilder()
        .mergeFrom(FileInputStream("funcionario-request.bin"))//pegamos ou lemos um arquivo binario de um determinado local

    request2.cargo = Cargo.GERENTE
    request2.build()

    println(request2)
}

