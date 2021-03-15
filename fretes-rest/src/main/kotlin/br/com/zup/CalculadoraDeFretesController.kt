package br.com.zup


import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.grpc.protobuf.StatusProto
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.exceptions.HttpStatusException
import java.lang.Exception
import javax.inject.Inject

@Controller
class CalculadoraDeFretesController(@Inject val gRpcClient: FretesServiceGrpc.FretesServiceBlockingStub) {

    @Get("/api/fretes")
    fun calcula(@QueryValue cep: String): FreteResponse {
        val req = CalculaFreteRequest.newBuilder()
            .setCep("61760-000")
            .build()

        try {

            val response = gRpcClient.calculaFrete(req)

            return FreteResponse(
                cep = response.cep,
                valor = response.valor
            )

        } catch (e: StatusRuntimeException) {

            val statusCode = e.status.code
            val description = e.status.description

            if (statusCode == Status.Code.INVALID_ARGUMENT){
                throw HttpStatusException(HttpStatus.BAD_REQUEST, description)
            }

            if(statusCode == Status.Code.PERMISSION_DENIED){
                val statusProto = StatusProto.fromThrowable(e)
                if(statusProto == null){
                    throw  HttpStatusException(HttpStatus.FORBIDDEN, description)
                }
                val details = statusProto.detailsList.get(0)
                val unpack = details.unpack(ErrorDetails::class.java)

                throw HttpStatusException(HttpStatus.FORBIDDEN, "${unpack.code}: ${unpack.message}" )
            }

            throw HttpStatusException(HttpStatus.INTERNAL_SERVER_ERROR, description)
        }
    }
}