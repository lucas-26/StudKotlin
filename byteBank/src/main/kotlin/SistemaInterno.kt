class SistemaInterno {

    fun entra(funcionario: FuncionarioAdmin, senha: Int){
        if(funcionario.autentica(senha)){
            print("Bem vindo")
        }
        else {
            println("Falha")
        }
    }

}