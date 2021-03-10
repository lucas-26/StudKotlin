package br.com.alura.bytebank.ParadigmaFuncional

fun main() {
    val minhaFuncaoSoma: (Int, Int) -> Int = ::soma
    println(minhaFuncaoSoma(5, 10))

    val minhaFuncaoLambda: (Int,Int, String) -> Int = { valo1, valor2, _ -> // esse _ é como uma passagem de parametro vazio, você coloca ele pos a funcao precisa desse parametro para funcionar mas ele está vazaio
        valo1 + valor2
    }
    println(minhaFuncaoLambda(20, 10,"vazio"))

    val minhaFuncaoAnonima: (Int, Int) -> Int = fun(valor1, valo2): Int{
        return valor1 + valo2
    }
    println(minhaFuncaoAnonima(10,55))

    val calculaBonificacao: (salario: Double) -> Double = labelMinhaFuncao@{ salario ->  //label da minha funcão lambda, assim ele sabe qual  o tipo de retorno ele deve aceitar
        if(salario > 1000.0){
            return@labelMinhaFuncao salario + 50.0
        }
        return@labelMinhaFuncao salario + 100
    }
    println(calculaBonificacao(20.0))

    val calculaBonificacaoAninima: (salario: Double) -> Double = fun (salario: Double): Double {
        if(salario > 1000.0){
            return salario + 50.0
        }
        return salario + 100
    }
    println(calculaBonificacaoAninima(1000.0))
}

fun soma(a: Int, b:Int): Int {
    return a + b
}

fun testaTipoFuncaoSoma() {
    val minhaFuncaoClasse: (Int, Int) -> Int = soma()
    println(minhaFuncaoClasse(10,10))
}

class soma : (Int, Int)  -> Int {
    override fun invoke(p1: Int, p2: Int): Int {
        return p1 + p2
    }
}