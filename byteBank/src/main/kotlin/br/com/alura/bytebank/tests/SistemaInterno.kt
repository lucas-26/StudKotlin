package br.com.alura.bytebank.tests

import br.com.alura.bytebank.models.Autenticavel

class SistemaInterno {

    fun entra(funcionario: Autenticavel, senha: Int, autenticado: () -> Unit = {}){
        if(funcionario.autenticar(senha)){
            print("Bem vindo")
            autenticado()
        }
        else {
            println("Falha")
        }
    }

}