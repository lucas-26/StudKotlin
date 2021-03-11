package br.com.zup.controller

import br.com.zup.model.Autor
import br.com.zup.repository.AutorRepository

import br.com.zup.request.AutorRequest
import br.com.zup.response.DetalhesDoAutorResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.Valid


@Validated
@Controller("/Autor")
class AutorController(val autorRepository: AutorRepository) {


    @Get("/BuscaAutores")
    @Transactional
    fun lista(@QueryValue(defaultValue = "") email: String): HttpResponse<Any> {//@QueryValue é o query parameter do spring
        if (email.isBlank()){
            val todosAutores = autorRepository.findAll()

            val response = todosAutores.map { autor -> DetalhesDoAutorResponse(autor) }

            return HttpResponse.ok(response)
        }
        val autorEncontrado = autorRepository.findByEmail(email)
        if (autorEncontrado.isEmpty){
            return HttpResponse.notFound()
        }
        val oAutorFoiEncontrado = autorEncontrado.get()

        return  HttpResponse.ok(DetalhesDoAutorResponse(oAutorFoiEncontrado))
    }

    @Get("/BuscaAutorPeloNome")
    @Transactional
    fun buscaAutorPeloNome(@QueryValue(defaultValue = "") nome: String):HttpResponse<Any> {
        nome.let { nomeAutor ->
            if(autorRepository.buscaAutorPornome(nomeAutor).isEmpty){
                return HttpResponse.notFound()
            }
            return HttpResponse.ok()
        }
    }

    @Post("/CadastraAutores")
    fun cadastra(@Body @Valid request: AutorRequest) {
        val autor: Autor = request.toModel()
        autorRepository.save(autor)
    }

    @Put("/AlteraDescricao/{nome}")
    fun AlteraDescricao(@PathVariable nome: String,descricao: String): HttpResponse<Any> {
        val autorExiste = autorRepository.buscaAutorPornome(nome)

        if(autorExiste.isEmpty) { return HttpResponse.notFound() }

        var autorAlteracao = autorExiste.get()
        autorExiste.let { it.get().descricao = descricao }

        autorRepository.update(autorAlteracao)
        return HttpResponse.ok()
    }
}