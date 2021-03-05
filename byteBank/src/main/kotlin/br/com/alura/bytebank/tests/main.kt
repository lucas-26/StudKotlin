package br.com.alura.bytebank.tests

import br.com.alura.bytebank.models.Autenticavel
import br.com.alura.bytebank.models.Cliente
import br.com.alura.bytebank.models.Conta
import br.com.alura.bytebank.models.ContaCorrente

fun main() {
    println("Bem vindo ao byte bank")

    val carla = object : Autenticavel { //Object expression, objeto anonimo que não pode ter nome
        val nome: String = "Carla"
        val  cpf: String = "111.111.111-11"
        override val senha: Int = 1000

        override fun autenticar(senha: Int): Boolean  = this.senha == senha
    }

    val contalUCAS: Conta = ContaCorrente(titular = Cliente("lucas", "85484484784", senha = 1245 ),numero = 2)
    val contaCarlos: Conta = ContaCorrente( numero =  2, titular = Cliente("lucas", "85484484784", senha = 1421))//labels, você passa os paramentros de maneira explicita e assim você não precisa passar na ordem que o construtor exige mas no final ele será passado de maneira correta
    val contaFran: Conta = ContaCorrente(Cliente("Francielle", "875484845", senha = 5154),1)

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

    if (contalUCAS.transferencia(contaFran, 55.0)) {
        println("Transfarencia para a fran efetuada");
    } else {
        println("falhou");
    }

    println("Sacando na conta do Francine");
    println(contaFran.saldo);
}