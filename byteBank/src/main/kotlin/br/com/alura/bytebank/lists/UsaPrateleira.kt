package br.com.alura.bytebank.lists

fun main() {
    val prateleira = Prateleira(genero = "Literatura", livros = ListaDeLivrodSemNull)

    prateleira.organizarPorAnoPublicacao().imprimeComMarcadore()
    prateleira.organizarPorAutor().imprimeComMarcadore()

    val organizaPorAno = prateleira.organizarPorAnoPublicacao()
    val organizaPorAutor = prateleira.organizarPorAutor()


}