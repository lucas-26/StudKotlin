package br.com.alura.bytebank.CollectionSetMap

fun main() {
    val assistiramCursoAndroid: Set<String> = setOf("Lucas", "Maria", "Carla", "Amanda")
    val assistiramOCursoKotlin: List<String> = listOf("Lucas", "Maria", "Josefina")
    //val assistiramAmbos:Set<String> = assistiramCursoAndroid + assistiramCursoAndroid isso é o mesmo de usar o metodo plus
    val assistiramAmbos: MutableSet<String> = mutableSetOf<String>()
    assistiramAmbos.addAll(assistiramCursoAndroid)
    assistiramAmbos.addAll(assistiramOCursoKotlin)
    println(assistiramAmbos)// ao declara esse objeto como set ele já retira os objetos repetidos da minha coleção pois isso é caracteristica do set
    println(assistiramCursoAndroid.union(assistiramOCursoKotlin)) // terá o mesmo resultado de somar as duas lists
    println(assistiramCursoAndroid.subtract(assistiramOCursoKotlin))//vai subtrair que participou do curso de kotlin e de android
    println(assistiramCursoAndroid.intersect(assistiramOCursoKotlin))//pega o que tem em android e em kotlin, pega os que estão nos dois conjuntos

}