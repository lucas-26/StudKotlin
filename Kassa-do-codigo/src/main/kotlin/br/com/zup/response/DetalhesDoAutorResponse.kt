package br.com.zup.response

import br.com.zup.model.Autor

data class DetalhesDoAutorResponse(var autor: Autor) {
    val nome = autor.nome
    val email = autor.email
    val descricao = autor.descricao

}
