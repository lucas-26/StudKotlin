package br.com.alura.bytebank.ParadigmaFuncional

import br.com.alura.bytebank.models.Autenticavel
import br.com.alura.bytebank.models.Endereco
import br.com.alura.bytebank.tests.SistemaInterno


fun main() {
    val endereco = Endereco(logradouro = "rua vergueiro", numero = 3185)
    val endereceoMaiusculo = "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
    println(endereceoMaiusculo)

//    val enderecoEmMaiusculo = Endereco(
//        logradouro = "rua vergueiro",
//        numero = 3185
//    ).let { myEndereco -> //hight order function, ao usar ela não é necessário fazer uma instancia de um objeto para invocar ela
//        "${myEndereco.logradouro}, ${myEndereco.numero}".toUpperCase()
//    }
//    println(enderecoEmMaiusculo)

    Endereco(
        logradouro = "rua vergueiro", //scope function, apply é um exemplo de scope function, ela tem o this implicito, o apply retorna o objeto de contexto
        numero = 3185
    ).apply { "$logradouro, $numero".toUpperCase() } // o aplly é uma funcao de escopo então ele já tem o acesso ao this, nesse caso isso $logradouro, $numero seria o mesmo que isso aqui $this.logradouro, $this.numero
                                                     // o apply retorna meu objeto de contexto o this
     Endereco(
        logradouro = "rua vergueiro",
        numero = 3185       //o let é uma função lambda, não tem retorno
    ).let { myEndereco -> //hight order function, ao usar ela não é necessário fazer uma instancia de um objeto para invocar ela
        "${myEndereco.logradouro}, ${myEndereco.numero}".toUpperCase()
    }.let(::println)//após colocar tudo em maiusculo, ele vai executar o println com o que foi retornado do let acima, no caso com a frase toda em maiusculo

     listOf(Endereco(complemento = "casa"), Endereco(), Endereco(complemento = "apartamento"))
        .filter { endereco -> endereco.complemento!!.isNotEmpty() }
        .let(::println)

    asoma(1, 2, resultado = {
        println(it) //quando esse código for executado, o que será mostrado é o !!!!A!!!! e o resultado vai ser executado retornando o resultado 3
    })

    val autenticavel = object : Autenticavel {
        override val senha = 1234
        override fun autenticar(senha: Int): Boolean {
            return this.senha == senha
        }
    }

    SistemaInterno().entra(autenticavel, 1234, autenticado = {
        println("realizar pagamento") //essa linha só será executada após a função passado como parametro no sistema interno for executado, a função que está na val autenticavel
    })
}

fun asoma(a: Int, b: Int, resultado: (Int) -> Unit){
    println("antes da soma") //!!!!A!!!! sendo executada
    resultado(a + b) //será executado e o resultado 3 será impresso
    println("depois da soma")
}
