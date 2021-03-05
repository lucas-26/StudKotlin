package tests

import models.Autenticavel

class SistemaInterno {

    fun entra(funcionario: Autenticavel, senha: Int){
        if(funcionario.autenticar(senha)){
            print("Bem vindo")
        }
        else {
            println("Falha")
        }
    }

}