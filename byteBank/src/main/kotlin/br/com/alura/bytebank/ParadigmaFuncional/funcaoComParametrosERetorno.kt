package br.com.alura.bytebank.ParadigmaFuncional

fun main() {
    val minhaFuncaoSoma: (Int, Int) -> Int = ::soma
    println(minhaFuncaoSoma(5, 10))

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