package br.com.zup

import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import javax.inject.Singleton

@Factory
class GrpcClientFactory {

    @Singleton              //Esse chanel aberto aqui é usado para criar um novo canal a partir das configurações que eu passei no meu arquivo aplication.yml
    fun fretesClientStub(@GrpcChannel("fretes") channel: ManagedChannel): FretesServiceGrpc.FretesServiceBlockingStub {
        return FretesServiceGrpc
                .newBlockingStub(channel)
    }
}