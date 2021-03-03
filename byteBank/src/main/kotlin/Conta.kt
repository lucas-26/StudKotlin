class Conta {
    var titular: String = "";
    var numero = 0;
    private var saldo: Double = 0.0;

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

    fun getSaldo(): Double{
        return saldo;
    }
}