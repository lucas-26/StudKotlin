package br.com.alura.bytebank.models

class Cliente(
    val nome:String,
    val cpf: String,
    var endereco:Endereco = Endereco(),
    override val senha: Int
): Autenticavel {

}