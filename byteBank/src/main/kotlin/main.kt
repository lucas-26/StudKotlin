fun main() {
    println("Bem vindo ao byte bank")

    val contalUCAS: Conta = Conta()
    val contaFran: Conta = Conta()



    contalUCAS.titular = "Lucas"
    contalUCAS.depositar(1000.0)
    contalUCAS.depositar(50.0)
    println(contalUCAS.titular)
    println("Sacando na conta do lucas")
    contalUCAS.sacar(400.0)
    println(contalUCAS.getSaldo())


    contaFran.titular = "Francine"
    contaFran.depositar(2000.0)
    contaFran.depositar(70.0)
    println(contaFran.titular)
    println("Sacando na conta do Francine")
    contaFran.sacar(400.0)
    println(contaFran.getSaldo())
    if (contalUCAS.tranferencia(contaFran, 55.0)) {
        println("Transfarencia para a fran efetuada");
    } else {
        println("falhou");
    }

    println("Sacando na conta do Francine");
    println(contaFran.getSaldo());
}