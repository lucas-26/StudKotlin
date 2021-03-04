class Diretor(nome:String, cpf:String, salario:Double, senha: Int, val plr: Double)
    : FuncionarioAdmin(nome = nome, cpf = cpf, salario = salario, senha = senha) //informando que gerente herda de funcionario
{
    override fun autentica(senha:Int): Boolean {
        if(this.senha == senha){
            return true;
        }
        return false;
    }

    override val bonificacao: Double
        get() {
            return salario + plr;
        }

}