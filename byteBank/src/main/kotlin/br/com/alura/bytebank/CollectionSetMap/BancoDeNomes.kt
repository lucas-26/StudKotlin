package br.com.alura.bytebank.CollectionSetMap

class BancoDeNomes {

    val nomes: Collection<String> get() = Companion.dados.toList()//um objeto somente readOnly
                                                                   //Ao usar o toList é retornado uma lista de somente leitura
    fun salvar(nome: String){
        Companion.dados.add(nome)
    }

    companion object {
        private val dados = mutableListOf<String>();//Restringindo o objeto, mantendo o emcapsulamento, assim não será qualquer um de fora que irá conseguir alterar nosso objeto. por ser um mutable liste ele é mutável
    }

}