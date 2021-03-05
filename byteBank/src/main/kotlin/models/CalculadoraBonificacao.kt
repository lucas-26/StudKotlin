package models

import models.Funcionario

class CalculadoraBonificacao {
    var total: Double = 0.0
            private set;

    fun registra(funcionario: Funcionario){ //polimorfismo, essa fun serve para qualque filho de funcionario
        this.total = funcionario.bonificacao;
    }
}