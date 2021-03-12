package br.com.zup.controller

import br.com.zup.Service.EnderecoClient
import br.com.zup.model.Autor
import br.com.zup.repository.AutorRepository

import br.com.zup.request.AutorRequest
import br.com.zup.response.DetalhesDoAutorResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import java.util.*
import javax.transaction.Transactional
import javax.validation.Valid


@Validated
@Controller("/Autor")
class AutorController(val autorRepository: AutorRepository, val enderecoClient: EnderecoClient) {


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
    fun buscaAutorPeloNome(@QueryValue(defaultValue = "") nome: String):HttpResponse<DetalhesDoAutorResponse> {
        nome.let { nomeAutor ->
            val buscaAutor = autorRepository.buscaAutorPornome(nomeAutor)
            if(buscaAutor.isEmpty){
                return HttpResponse.notFound()
            }
            return HttpResponse.ok(DetalhesDoAutorResponse(buscaAutor.get()))
        }
    }

    @Post("/CadastraAutores")
    @Transactional
    fun cadastra(@Body @Valid request: AutorRequest): HttpResponse<Any> {

        val enderecoResponse = enderecoClient.consult(request.cep)

        val autor: Autor = request.toModel(enderecoResponse.body()!!)
        autorRepository.save(autor)

        val uri = UriBuilder.of("autores/{nome}").expand(mutableMapOf(Pair("nome", autor.nome)))

        return HttpResponse.created(uri)
    }

    @Put("/AlteraDescricao/{nome}")
    @Transactional
    fun AlteraDescricao(@PathVariable nome: String,descricao: String): HttpResponse<Any> {
        val autorExiste = autorRepository.buscaAutorPornome(nome)

        if(autorExiste.isEmpty) { return HttpResponse.notFound() }

        var autorAlteracao = autorExiste.get()
        autorExiste.let { it.get().descricao = descricao }

        //autorRepository.update(autorAlteracao) por estar usando o @Transactional, quando esse metodo é executado ele abre a conexão com o banco e deixa aberto até a fun terminar
        return HttpResponse.ok() //Com isso ao executarmos o autorRepository.buscaAutorPornome(nome) já deixa esse objeto com estado managed no hibernate por isso ao fazer a operação it.get().descricao = descricao o hibernate consegue alterar o objeto
    }

    @Delete("/DeletarAutor/{nome}")
    @Transactional
    fun deletar(@PathVariable nome:String): HttpResponse<Any> {
        val atuor: Optional<Autor> = autorRepository.buscaAutorPornome(nome)
        atuor.let { autor ->
            if(autor.isEmpty){
                return HttpResponse.notFound()
            }
            autorRepository.delete(autor.get())
            return HttpResponse.ok()
        }
        return HttpResponse.badRequest()
    }
}