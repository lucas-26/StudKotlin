package br.com.alura.bytebank.lists

fun main() {
    ListaComNull.
        groupBy { it?.editora ?: "Editora desconhecida"}.//o group by irá retornar um map com chave e valor para nós, usando o elvis operator, se o valor da esquerda for null ele assumirá o valor que está na direita
            forEach{ (editora: String?, livros: List<Livros?>) ->   //editora é a chave e livros é o valor
                println("$editora: ${livros.joinToString { it!!.titulo }}")
            }
}