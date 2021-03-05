package br.com.alura.bytebank.tests

fun main() { //procedural
    for (i in 1..5) { //1 até 5,
        println("Bem vindo ao byte bank")
        var titular: String =
            "Lucas $i";  //variavel que o valor pode ser modificado, usando o :String estamos informando o tipo da variavel
        val titularUm = "Lucas"; //variavel que o valor não pode ser modificado
        val numeroConta = 1000 + i;
        var saldo: Double =
            1.0 + i;  //saldo= 10 -> isso dá erro pois não é possivél atribuir um valor int para uma variavel do tipo double
        //    saldo = 100 + 2.0;
        //    saldo += 200
        saldo -= 1000
        println(titular);
        println("titular: $titular");//string template
        println("numero br.com.alura.bytebank.models.Conta: $numeroConta");
        println("saldo: $saldo");
        println("------------------------------------------------------");

        testaCondicoes(saldo)
    }
}

fun testaCondicoes(saldo: Double) {
    if (saldo > 0.0) {
        println("br.com.alura.bytebank.models.Conta positiva");
    } else if (saldo == 0.0) {
        println("conta neutra");
    } else {
        println("br.com.alura.bytebank.models.Conta negativa");
    }

    when { //semelhante com um switch case
        saldo > 0.0 -> println("br.com.alura.bytebank.models.Conta positiva");
        saldo == 0.0 -> println("conta neutra");
        else -> println("br.com.alura.bytebank.models.Conta negativa");
    }
}

fun estruturaDeRepeticao() {

    for (i in 5 downTo 1) { //5 até 1,


    }

    for (i in 5 downTo 1 step 2) { //5 até 1 de 2 em 2.

    }

    for (i in 5 downTo 1 step 2) { //5 até 1 de 2 em 2. com o break
        if (i == 5) {
            break;
        }
    }

    var x = 2
    while (x > 5) { //x até 5
        x++;
    }
}