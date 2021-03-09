package br.com.alura.bytebank.CollectionSetMap

fun main() {
    val assistiramCursoAndroid = listOf("Lucas", "Maria", "Carla", "Amanda")
    val assistiramOCursoKotlin = listOf("Lucas", "Maria", "Josefina")

    val assistiramAmbos = mutableListOf<String>()
    assistiramAmbos.addAll(assistiramCursoAndroid.distinct())//o distinct retorna somente os elementos que não estão se repetindo


}