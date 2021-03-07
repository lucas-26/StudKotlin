package br.com.alura.bytebank.tests

import br.com.alura.bytebank.models.Endereco

fun main() {
    var endereco: Endereco? = null //informando que esse objeto no momento da instancia pode ser nullo
    endereco!!.logradouro//usando o !! estamos informando que nos temos certeza que essa instancia não sera null mas se for pode gerar uM kotlin.KotlinNullPointerException

    endereco?.logradouro?.length?.dec() // com essa ? se for null irá retornar null e não vai tenatar acessar o logradouro, caso não seja null ele irá acessar o logradouro

    endereco?.let { //o let se torne interessante pois com ele podecmos fazer algo com a variavel sem precisar usar o ? em toda chamada
        println(it.logradouro.length.dec())
        var valor = 1
        var tamanhoComplemento = it.complemento?.length ?: 0 //elvis operato define um valor padrão, se o valor de complemento for null ele ira retornar 0
        var tamanhoComplementa = it.complemento?.length ?: throw IllegalAccessError()
        var numero: Int? = valor as? Int // se o valor que vinher de valor não for um int ele não vai dar um exception e só atribuir um valor null
    }
}