package br.com.zup

import com.google.protobuf.Timestamp
import io.grpc.ServerBuilder
import io.grpc.stub.StreamObserver
import java.time.LocalDateTime
import java.time.ZoneId

fun main() {
    val server = ServerBuilder.forPort(500051)//instaciando um servidor grpc de maneira manual
        .addService(FuncionarioEndPoint())//adicionando o serviço ou "endpoit" que o grpc vai buscar para processar as informações
        .build()//configurando o servidor

    server.start()//iniciando o servidor
    server.awaitTermination()//travar a thred pois ele iria ser finalizada após esse metodo main terminar
}

class FuncionarioEndPoint : FuncionarioServiceGrpc.FuncionarioServiceImplBase() {

    //funcao de cadastro de uma nova mensagem no grpc, se fosse uma api rest esse seria um post para criar um novo usuario
    override fun cadastrar(request: FuncionarioRequest?, responseObserver: StreamObserver<FuncionarioResponse>?) {

        var nome: String? = request?.nome
        if (!request?.hasField(FuncionarioRequest.getDescriptor().findFieldByName("nome"))!!){
            nome = "[???]"
        }
        val instant = LocalDateTime.now().atZone(ZoneId.of("UTC")).toInstant()
        val criadoEm = Timestamp.newBuilder()
            .setSeconds(instant.epochSecond)
            .setNanos(instant.nano )
            .build()

        val response = FuncionarioRequest.newBuilder() // sempre usando o buider para criar um objeto dentro do grpc
            .setNome(nome)
            .setCriadoEm(criadoEm)
            .build()

        responseObserver?.onNext(response)
    }

}