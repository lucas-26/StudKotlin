package models

interface Autenticavel {

    val senha: Int

    fun autenticar(senha: Int) : Boolean {
        if(this.senha == senha){
            return true;
        }
        return false;
    }

}