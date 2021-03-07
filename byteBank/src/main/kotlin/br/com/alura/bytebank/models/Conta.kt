package br.com.alura.bytebank.models

import br.com.alura.bytebank.exception.SaldoInsuficienteException

//var totalContas:Int = 0  <- isso é uma variavel/property global
//    private set;

abstract class Conta(
    var titular:Cliente,
    var numero:Int) { //contrutor primario, os parametros do construtor primario e do construtor secundario não podem ser iguais
    //var titular: String = titular;                //ao usar o var no construtor estamos sendo idiomaticos em relação ao kotlin pois ao inserir assim ele já sabe que são as nossas properties que estão vindo pelo construtor
//    var numero = 0
//        private set
//    init { //executado logo em seguida que o construtor é executado
//        numero = 1
//    }
    var saldo: Double = 0.0
        protected set;//somente os filhos podem editar esse campo
    //private set; // o acesso a variavél é publico mas acessar o set não, é feito apenas pela nossa classe
//        set(valor){ //setter da linguagem kotlin, o get e o set são chamado de properties
//            println(field)//field é o valor interno, nesse caso ele recebe o valor do saldo, dentro das properties é como se ele fosse o saldo.
//        }
//        get(){ //getter da linguagem kotlin, o get e o set são chamado de properties
//            return field;//o field é como se fosse o valor dentro das properties da minha váriavel
//        }

    companion object  { //object declarations, pertence a classe e não ao objeto
        var total = 0           //usando o companion esse object só pode ser acessado denteo da classe conta
            private set;
    }

    init {
        total++
    }
//    constructor(titular:String, numero:Int, saldo:Double){ // construtor secundario
//        this.titular = titular;
//        this.numero = numero;
//        this.saldo = saldo
//    }
    abstract fun depositar(valor:Double): Double;
//    fun depositar(valor: Double) {
//        this.saldo += valor;
//    }
//
    abstract fun sacar(valor: Double): Double;
//    open fun sacar(valor: Double) {
//        if (this.saldo >= valor) {
//            saldo -= valor;
//        }
//    }
//
    //abstract fun transferencia(destino: Conta, valor: Double): Boolean;
    fun tranferencia(destino: br.com.alura.bytebank.models.Conta, valor: Double){
    if(saldo < valor){
        throw SaldoInsuficienteException();
    }
            this.sacar(valor);
            destino.depositar(valor);
    }
}