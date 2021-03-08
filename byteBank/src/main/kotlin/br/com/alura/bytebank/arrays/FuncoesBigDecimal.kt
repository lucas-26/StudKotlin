package br.com.alura.bytebank.tests

import java.math.BigDecimal

fun bigDecimalArrayOf(vararg valores:String): Array<BigDecimal>{//vararg é um parametro que recebe tudo que nó passarmos como parametro da função e vai colocar tudo em um array de String
    return Array<BigDecimal>(valores.size) { i ->
        valores[i].toBigDecimal();
    }
}

fun Array<BigDecimal>.somatorio(): BigDecimal {
    return this.reduce { acumulator, valor ->
        acumulator + valor
    }
}

fun Array<BigDecimal>.media():BigDecimal{
    return if(this.isEmpty()){
        BigDecimal.ZERO
    } else {
        this.somatorio() / this.size.toBigDecimal()
    }
}