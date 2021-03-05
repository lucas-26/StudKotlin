package models

class Diretor(nome:String, cpf:String, salario:Double, senha: Int, val plr: Double)
    : FuncionarioAdmin(nome = nome, cpf = cpf, salario = salario, senha = senha),
    Autenticavel //informando que gerente herda de funcionario
{
    override fun autenticar(senha:Int): Boolean {
        return  super<FuncionarioAdmin>.autentica(senha);// informando que eu quero sobreescrever o metodo que está na classe funcionario Admin e não na interface
    }

    override val bonificacao: Double
        get() {
            return salario + plr;
        }

}