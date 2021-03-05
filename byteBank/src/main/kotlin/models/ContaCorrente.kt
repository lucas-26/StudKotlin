package models

class ContaCorrente(titular: String, numero: Int)
    : Conta(
            titular = titular,
            numero = numero,
            ){
    override fun depositar(valor: Double): Double {
        TODO("Not yet implemented")
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