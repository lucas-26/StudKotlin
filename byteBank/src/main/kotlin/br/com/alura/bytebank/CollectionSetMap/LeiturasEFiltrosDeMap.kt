package br.com.alura.bytebank.CollectionSetMap

fun main() {
    var pedidos = mapOf<Int, Double>(Pair(1, 20.0), 2 to 50.0, 3 to 250.0, 4 to 100.0, 5 to 150.0)
    val valorPedido = pedidos.getValue(5)//ao buscar um valor que não existe o getValue vai retornar uma exception
    val valorPedido1 = pedidos.get(5)//o get vai retornar um null e não dará uma exception
    pedidos.getOrElse(1, {//caso encontre o pedido eve vai retornar o valor
        "não tem o pedido"      //caso não encontre, essa String aqui será retornada
    })
    pedidos.getOrDefault(1,-1.0)//se ao procurar o registro com a chave 1 o que será retornado é -1

    for(numeroDePedidos in pedidos.keys){
        println("pedido $numeroDePedidos")
    }
    for(valor in pedidos.values){
        println("pedido $valor")
    }

    val pedidosFiltrados = pedidos.filter { (numero, valor) -> //aqui para fazer o filtro, é necessário mandar entre parenteses tanto a chave quanto o valor
        numero % 2 == 0 && valor > 50.0
    }

    val pedidosAcima = pedidos.filterValues { valor ->//filtrando pelos values
        valor > 50.0
    }

    val pedidosperes = pedidos.filterKeys { chaves -> //filtrando pelas chaves
        chaves % 2 == 0
    }

    //pedidos.putAll(setOf<Pair<Int, Double>>(2 to 50.0, 3 to 250.0,))
    pedidos += setOf<Pair<Int, Double>>(2 to 50.0, 3 to 250.0,)//tem a mesma função do método acima

    //pedidos.keys.remmove(1) // remove a partir da chave, nesse caso vai remover o registro que tem a chave 1

}