abstract class Funcionario(val nome:String, val cpf:String, val salario:Double) { //ao usar o open o kotlin permite que outras classes herdem de funcionario

    abstract val bonificacao: Double //quando a funcao vira abstrata ela não pode ter implementação
                                     //Essa função deve ser obrigatoriamente implementada pelas calsses que vão herdar dessa classe abstrata
//    open val bonificacao: Double//bonificacao como uma property da classe
//        get() {
//            return salario * 0.1
//        }

//    open fun bonificacao(): Double { //bonificacao como uma função da classe
//        return  salario * 0.1
//    }
}