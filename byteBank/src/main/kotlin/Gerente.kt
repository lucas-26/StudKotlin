class Gerente(nome:String, cpf:String, salario:Double, senha: Int)
    : FuncionarioAdmin(nome = nome, cpf = cpf, salario = salario, senha) //informando que gerente herda de funcionario
{
        override fun autentica(senha:Int): Boolean {
            if(this.senha == senha){
                return true;
            }
            return false;
        }

    override val bonificacao: Double
        get() {
            return salario
        }
}