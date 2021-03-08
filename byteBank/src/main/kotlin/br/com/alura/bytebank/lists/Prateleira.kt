package br.com.alura.bytebank.lists

class Prateleira(
    val genero: String,
    val livros: List<Livros>// a classe list é imutavel
) {
    fun organizarPorAutor(): List<Livros> {
        return livros.sortedBy { it.autor }
    }

    fun organizarPorAnoPublicacao(): List<Livros> {
        return livros.sortedBy() { it.anoPublicacao }
    }
}