fun main() {
    println("Bem vindo ao byte bank")

    val contalUCAS: Conta = Conta("Lucas", 2, 100.0)
    val contaCarlos: Conta = Conta(saldo = 100.0, numero =  2, titular = "Lucas", )//labels, você passa os paramentros de maneira explicita e assim você não precisa passar na ordem que o construtor exige mas no final ele será passado de maneira correta
    val contaFran: Conta = Conta("Francine", 1, 2000.0)

    contalUCAS.depositar(50.0)
    println(contalUCAS.titular)
    println("Sacando na conta do lucas")
    contalUCAS.sacar(400.0)
    println(contalUCAS.saldo)

    contaFran.depositar(70.0)
    println(contaFran.titular)
    println("Sacando na conta do Francine")
    contaFran.sacar(400.0)
    println(contaFran.saldo)


    if (contalUCAS.tranferencia(contaFran, 55.0)) {
        println("Transfarencia para a fran efetuada");
    } else {
        println("falhou");
    }

    println("Sacando na conta do Francine");
    println(contaFran.saldo);
}