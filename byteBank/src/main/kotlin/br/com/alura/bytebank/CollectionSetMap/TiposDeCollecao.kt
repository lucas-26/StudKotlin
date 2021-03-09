package br.com.alura.bytebank.CollectionSetMap

fun main() {
    val nomes:Collection<String> = //Collection é uma coleção do tipo imutavel
            mutableListOf("lucas", "carlos", "joão", "Guilherme", "Marcos")

    val banco = BancoDeNomes()
    val nomesSalvos: MutableCollection<String> = banco.nomes as MutableCollection<String> // ao fazer esse cast, esse "as" estamos quebrando o encapsulamento, pois agora estamos trabalhando com uma lista mutavel
    banco.salvar("Alex")                                                            //isso vai dar erro pois após adicionar o Tolist() no banco de nomes recebemos só uma cópia e read only, portanto esse cast que foi feito acima, vai resultar em uma exception
    println(banco.nomes)
    println(nomesSalvos)
}