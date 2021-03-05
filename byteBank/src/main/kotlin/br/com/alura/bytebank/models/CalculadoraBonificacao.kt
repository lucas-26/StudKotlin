package br.com.alura.bytebank.models

class CalculadoraBonificacao {
    var total: Double = 0.0
            private set;

    fun registra(funcionario: Funcionario){ //polimorfismo, essa fun serve para qualque filho de funcionario
        this.total = funcionario.bonificacao;
    }

    fun registra(funcionario: Any){
        funcionario as Funcionario// no kotlin o as é que faz um cast
        this.total += funcionario.bonificacao
    }
}