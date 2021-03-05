package br.com.alura.bytebank.models

class ContaCorrente(titular: Cliente, numero: Int)
    : Conta(
            titular = titular,
            numero = numero,
            ){
    override fun depositar(valor: Double): Double {
       if(valor >= this.saldo){
           print("deu certo")
           return 1.0;
       }
        return 0.0;
    }

    override fun sacar(valor: Double): Double {
        val valorComTaxa = valor + 0.1;
        if(this.saldo >= valorComTaxa){
            this.saldo -= valorComTaxa
        }
        return valorComTaxa
    }

    override fun transferencia(destino: Conta, valor: Double): Boolean {
        TODO("Not yet implemented")
    }

}