package br.com.zup.Service

import br.com.zup.response.EnderecoResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client
import java.awt.PageAttributes
import java.net.http.HttpResponse

@Client("http://localhost:8081/cep/busca")
interface EnderecoClient {

    @Get(consumes = [ MediaType.APPLICATION_XML],// informando ao micronaut que a resposta será um xml e não um json
         produces = [ MediaType.APPLICATION_XML ]) //podemos informar também que ele irá produzir um xml
    @Consumes(MediaType.APPLICATION_XML) //fazendo o mesmo que está acima mas por meio de anotações
    @Produces(MediaType.APPLICATION_XML) //fazendo o mesmo que está acima mas por meio de anotações
        fun consult(@QueryValue cep: String): HttpResponse<EnderecoResponse>

}
