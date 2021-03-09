package br.com.alura.bytebank.CollectionSetMap

fun main() {
    val nome:List<String> = listOf("Lucas", "Ana", "Carlos", "Maria", "José")//uma list é representada por uma collection
    println(nome)

    val nomes:Iterable<String> = listOf("Lucas", "Ana", "Carlos", "Maria", "José")//iterable é uma referencia mais generica se tratando de coleções, ela está um nivel acima de abstração em relaçãoa o list

    val nomis:Collection<String> = listOf("Lucas", "Ana", "Carlos", "Maria", "José")

    for (mynome in nomes.iterator()){
        println(mynome)
    }
    println(nomes)
    println(nomes.contains("Lucas"))
    //println(nomes.size())//isso não vai funcionar
    //println(nomis.size())//ao tentar usar o size em uma collection ´metodo size funciona mas ao tentar usar ele em um iterable o mesmo não vai funcionar
}