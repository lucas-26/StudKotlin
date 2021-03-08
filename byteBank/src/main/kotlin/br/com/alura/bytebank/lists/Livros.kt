package br.com.alura.bytebank.lists

data class Livros // ao usar o data ela já fornece alguns métodos para nós em tempo de compilação como equals, hashcode sem que seja necessário implementar, como o
    (
    val titulo: String,
    val autor: String,
    val anoPublicacao: Long,
    val editora: String? = null
    ): Comparable<Livros>{

    override fun compareTo(other: Livros): Int {
        return this.anoPublicacao.compareTo(other.anoPublicacao)
    }

}