package br.com.zup.model

import br.com.zup.response.EnderecoResponse
import javax.persistence.Embeddable

@Embeddable
class Endereco(enderecoResponse: EnderecoResponse,
               numero: String,
               cep: String) {

    val rua = enderecoResponse.rua
    val cidade = enderecoResponse.cidade
    val estado = enderecoResponse.estado
}
