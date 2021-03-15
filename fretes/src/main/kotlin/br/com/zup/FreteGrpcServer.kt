package br.com.zup

import com.google.protobuf.Any
import com.google.rpc.Code
import  io.grpc.protobuf.StatusProto
import io.grpc.Status
import io.grpc.stub.StreamObserver
import org.slf4j.LoggerFactory
import java.lang.Exception
import java.lang.IllegalStateException
import javax.inject.Singleton
import kotlin.random.Random

@Singleton//Essa anotação é colocada para ser reconhecida pelo micronaut
class FreteGrpcServer : FretesServiceGrpc.FretesServiceImplBase() { //Essas classes que estamos herdando, é criados pela nossa ferramenta de grpc
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun calculaFrete(request: CalculaFreteRequest?, responseObserver: StreamObserver<CalculaFreteResponse>?) { //overrride no method criado lá no arquivo protobuf
        logger.info("Calculando frete para $request")

        val cep = request!!.cep
        if(cep == null || cep.isBlank()){
            val error = Status.INVALID_ARGUMENT
                .withDescription("cep deve ser informado")
                .asRuntimeException()
            responseObserver?.onError(error)
            return
        }

        if(!cep.matches("[0-9]{5}-[\\d]{3}".toRegex())){
            responseObserver?.onError(Status.INVALID_ARGUMENT
                .withDescription("Esse cep é invalido")
                .augmentDescription("formato esperado é 99999-999")
                .asRuntimeException())
            return
        }

        if(cep.endsWith("333")){
            val statusProtocol = com.google.rpc.Status.newBuilder()
                .setCode(Code.PERMISSION_DENIED.number)
                .setMessage("Sem permissão para acessar esse recurso")
                .addDetails(Any.pack(ErrorDetails.newBuilder()
                    .setCode(401).setMessage("toke expirado").build())).build()
            val e = StatusProto.toStatusRuntimeException(statusProtocol)
            responseObserver?.onError(e)
            return
        }

        var valor = 0.0

        try {
            valor = Random.nextDouble(from = 0.0, until = 140.0)
            if (valor > 100.0){
                throw IllegalStateException("Erro inesperado simulado")
            }
        } catch (e: Exception){
            responseObserver?.onError(Status.INTERNAL
                            .withDescription(e.message)
                            .withCause(e)
                            .asRuntimeException())
            return
        }

        val response = CalculaFreteResponse.newBuilder()
            .setCep(request?.cep)
            .setValor(Random.nextDouble(from = 0.0, until = 140.0))
            .build()

        logger.info("Frete calculado: $response")

        responseObserver?.onNext(response)
        responseObserver?.onCompleted()
    }
}