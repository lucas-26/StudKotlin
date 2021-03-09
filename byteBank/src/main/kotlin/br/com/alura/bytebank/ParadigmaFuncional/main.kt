package br.com.alura.bytebank.ParadigmaFuncional

fun main() {

    val minhaFuncao: () -> Unit = ::teste  //tipo função, todo tipo função precisa de um retorno
    println(minhaFuncao())
    val minhaFuncaoClasse: () -> Unit = Teste()
}

fun teste(){
    println("executa Minha funcao")
}

class Teste : () -> Unit {
    override fun invoke() {
        println("Executa Invoke")
    }
}