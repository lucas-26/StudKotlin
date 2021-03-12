package br.com.zup.model

import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class Autor(
    val nome: String,
    val email: String,
    var descricao: String,
    @field:Embedded val endereco: Endereco
){
    @Id
    @GeneratedValue
    var id: Long? = null
    val criadoEm: LocalDateTime = LocalDateTime.now()
}