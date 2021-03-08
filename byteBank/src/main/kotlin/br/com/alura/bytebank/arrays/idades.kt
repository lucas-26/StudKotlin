package br.com.alura.bytebank.tests

fun main() {
    val idades: IntArray = intArrayOf(10, 12, 18, 33, 40, 67)
    val maiorIdade = idades.max()//pegando a maior idade dentro do array
    println(maiorIdade)

    val menorIdade = idades.min()//pegando a menor idade dentro do array
    println(menorIdade)

    val idadeMedia = idades.average() //calculando a média de idades dentro do array
    println(idadeMedia)

    val todosMaioresDeDezoito = idades.all { it > 18 }// ele vai varrer o array e para todos os registro ele vai fazer a validação, it = valor > 18 e se todos forem ele vai retornar true, se em um não for verdade ele vai retornar false
    println(todosMaioresDeDezoito)

    val umTemDezoito = idades.any { it > 18}//verificar se ao menos um dos valores dentro do array é maior de 18
    println(umTemDezoito)

    val listaMaioresDezoito = idades.filter { it >= 18  } //vai retornar uma lista com os alunos que estão dentro da lista e tem a idade maior que 18
    println(listaMaioresDezoito)

    val udadeDezoito = idades.find { it >= 18 }//Vai retornar uma valor que tem a idade igual a 18
    println(udadeDezoito)


}