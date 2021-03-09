package br.com.alura.bytebank.CollectionSetMap

fun main() {
    val pedidos = listOf(
        Pedido(1, 20.0),
        Pedido(2, 60.0),
        Pedido(3, 30.0),
        Pedido(4, 70.0)
    )
    println(pedidos)
    val pedidosMapeados: Map<Int, Pedido> = pedidos.associateBy { pedido -> pedido.numero }
    println(pedidosMapeados)

//    val pedidosFreteGratis = pedidos.associateWith { pedido ->
//        pedido.valor > 50.0
//    }
//    println(pedidosFreteGratis)

    val pedidosFreteAgrupados: Map<Boolean, List<Pedido>> = pedidos.groupBy { pedido: Pedido ->
        pedido.valor > 50.0
    }
    println(pedidosFreteAgrupados)//Vai retornar uma lista com os pedidos agrupados em duas posições, um false com todos os pedidos que não tem frete gratis e um com true com todos os pedidos que tem frete gratis
    println(pedidosFreteAgrupados[false])//Vai retornar uma lista com todos os pedidos que estão em false, todos os maps que não tem o valro maior que 50

    val nomes = listOf("Lucas", "fran", "Carlos", "Jessica", "Prietro", "João")
    val agenda: Map<Char, List<String>> = nomes.groupBy { nome ->
        nome.first()
    }
    println(agenda) //retorna os nomes com a primeira letra do nome iguais
    println(agenda['L'])//vai retornar uma lista com todos os usuátios que começam com a letra L
}