package br.com.alura.bytebank.CollectionSetMap

fun main() {
    val pedidos = mutableMapOf<Int, Double>(Pair(1, 20.0), 2 to 50.0)// O Pair(1, 20.0) é mais performatico que o  2 to 50.0
    println(pedidos)
    val pedido = pedidos[1]
    pedido?.let { println(it) }

    for( p: Map.Entry<Int, Double> in pedidos ){
        println(p.key)
        println(p.value)
    }
    pedidos[4] = 70.0//inserindo uma nova chave e valor dentro do map, isso só é possivel pois é um mutable map
    println(pedidos)

    pedidos.put(1, 100.0)//com o put é possivel inserir um novo registro dentro do map ou alterar um registro que já existe
    pedidos.putIfAbsent(5, 200.0)//só vai inserir um novo valor se não existir um objeto nessa chave, nesse caso na chave 5

    pedidos.remove(4)//remove um pedido de acordo com a chave que está sendo passada
    println(pedidos)

    pedidos.remove(4, 70.0)//nesse caso esse registro só será removido caso o valor que ele contenha seja igual a 70
}