package br.com.zup

import io.grpc.ManagedChannelBuilder

fun main() {

    val channel = ManagedChannelBuilder.forAddress("localhost", 50051)//informando o endereço que vamos nos conectar
        .usePlaintext()
        .build()


    val request = FuncionarioRequest.newBuilder() //montando o objeto
        .setNome("Lucas Araujo")
        .setCpf("000.000.000-00")
        .setIdade(23)
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addAllEnderecos(FuncionarioRequest.Endereco.newBuilder()
            .setLogradouro("Rua das Andorinhas")
            .setCep("00000-000")
            .setComplemento("Casa 20")).build()


    val client = FuncionarioServiceGrpc.newBlockingStub(channel)
    val response = client.cadastrar(request)//chamando o metodo de cadastro criado na classe que criamos o servidor e o metodo cadastro
}