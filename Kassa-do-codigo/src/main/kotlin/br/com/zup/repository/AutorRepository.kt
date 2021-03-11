package br.com.zup.repository

import br.com.zup.model.Autor
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface AutorRepository: JpaRepository<Autor, Long> {

    fun findByEmail(email: String): Optional<Autor>

    @Query("SELECT a FROM Autor a WHERE a.nome = :nome ORDER BY a.criadoEm") //uma query explicita
    fun buscaAutorPornome(nome: String): Optional<Autor>
}