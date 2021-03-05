package br.com.alura.bytebank.models

class Gerente(nome:String, cpf:String, salario:Double, senha: Int)
    : FuncionarioAdmin(nome = nome, cpf = cpf, salario = salario, senha),
    Autenticavel //informando que gerente herda de funcionario
{
        override fun autenticar(senha:Int): Boolean {
           return super<Autenticavel>.autenticar(senha); //informando que eu quero sobreescrever o método que vem de autenticavel, não o que vem de funcionario admin
        }

    override val bonificacao: Double
        get() {
            return salario
        }
}