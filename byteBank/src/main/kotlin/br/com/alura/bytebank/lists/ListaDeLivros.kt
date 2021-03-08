package br.com.alura.bytebank.lists

fun main() {
    val livro1 = Livros(
        titulo = "Grande Sertão: Veredas",
        autor = "João Guimarães Rosa",
        anoPublicacao = 1956
    )

    val livro2 = Livros(
        titulo = "Minha vida de menina",
        autor = "Helena Morley",
        anoPublicacao = 1942,
        editora = "Editora A"
    )

    val livro3 = Livros(
        titulo = "Memórias Póstumas de Brás Cubas",
        autor = "Machado de Assis",
        anoPublicacao = 1881
    )

    val livro4 = Livros(
        titulo = "Iracema",
        autor = "José de Alencar",
        anoPublicacao = 1865,
        editora = "Editora B"
    )

    val livros:MutableList<Livros> = mutableListOf(livro1, livro2, livro3, livro4)//lista mutavel de
    livros.imprimeComMarcadore()

    val ordenadoAnoPublicacao = livros.sorted() //aqui precisamos implementar o método compareTo na classe livro, assim ordenado so livro comparando pelas suas datas de cadastro.
    ordenadoAnoPublicacao.imprimeComMarcadore()

    val ordenadoPorTitulo =
        livros.sortedBy { it.titulo }// aqui tem a mesma função da funcao sorted, a diferença é que não necessita implementação e ele ordena pelo parametro que estamos passando entre chaves
    ordenadoPorTitulo.imprimeComMarcadore()

    val imprimePorAutores = livros.sortedBy { it.autor }
    imprimePorAutores.imprimeComMarcadore()

    livros.filter { it.autor == "João Guimarães Rosa" }
        .sortedBy { it.anoPublicacao }.imprimeComMarcadore()

    livros.filter { it.autor.startsWith("João") }
        .sortedBy { it.anoPublicacao }.imprimeComMarcadore()

    livros.filter { it.autor.startsWith("J") } //na minha lista de livros, filtrando o pelo autor, que tem a letra j no inicio
        .sortedBy { it.anoPublicacao }//ordenando pelo ano de publicação
        .map { it.titulo }//pedindo no retorno apenas os titulos dos livros, no caso virá uma lista de strings
}

fun List<Livros?>.imprimeComMarcadore(){
    val joinToString = this
        .filterNotNull() //filtrando e pegando somente os registros que não são null, o kotlin tem esse método já implementado que faz isso para nós
        .joinToString(separator = "\n") {
        " - ${it.titulo} de ${it.autor}"//com o it?.titulo falamos para o kotlin para ele chamar o titulo só se o it não for null
    }
    println(joinToString)
}