class Conta(var titular:String, var saldo:Double) { //contrutor primario, os parametros do construtor primario e do construtor secundario não podem ser iguais
    //var titular: String = titular;                //ao usar o var no construtor estamos sendo idiomaticos em relação ao kotlin pois ao inserir assim ele já sabe que são as nossas properties que estão vindo pelo construtor
    var numero = 0
        private set
    init { //executado logo em seguida que o construtor é executado
        numero = 1
    }
    //var saldo: Double = saldo;
        //private set; // o acesso a variavél é publico mas acessar o set não, é feito apenas pela nossa classe
//        set(valor){ //setter da linguagem kotlin, o get e o set são chamado de properties
//            println(field)//field é o valor interno, nesse caso ele recebe o valor do saldo, dentro das properties é como se ele fosse o saldo.
//        }
//        get(){ //getter da linguagem kotlin, o get e o set são chamado de properties
//            return field;//o field é como se fosse o valor dentro das properties da minha váriavel
//        }

    constructor(titular:String, numero:Int, saldo:Double){ // construtor secundario
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldo
    }

    fun depositar(valor: Double) {
        this.saldo += valor;
    }

    fun sacar(valor: Double) {
        if (this.saldo >= valor) {
            saldo -= valor;
        }
    }

    fun tranferencia(destino: Conta, valor: Double): Boolean {
        if (this.saldo >= valor) {
            this.sacar(valor);
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}