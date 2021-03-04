fun main() {

    val luan = Diretor(nome = "Luan", cpf = "91123222312",salario = 200.0, senha = 1234, plr = 5000.0);
    val lars = Gerente(nome = "Lars", cpf = "91123222312",salario = 200.0, senha = 1234);

    println("o funcionario ${luan.nome}, bonificacao ${luan.bonificacao}")

    val calculador:CalculadoraBonificacao = CalculadoraBonificacao()
    calculador.registra(luan)
    calculador.registra(lars)

    println(calculador.total)

}