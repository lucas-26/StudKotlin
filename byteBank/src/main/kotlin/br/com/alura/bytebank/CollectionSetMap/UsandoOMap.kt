package br.com.alura.bytebank.CollectionSetMap

fun main() {
    val pedidos = mapOf<Int, Double>(Pair(1, 20.0), 2 to 50.0)// O Pair(1, 20.0) é mais performatico que o  2 to 50.0
    println(pedidos)
    val pedido = pedidos[1]
    pedido?.let { println(it) }

    for( p: Map.Entry<Int, Double> in pedidos ){
        println(p.key)
        println(p.value)
    }
}