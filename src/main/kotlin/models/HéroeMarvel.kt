package org.example.models

data class HéroeMarvel (val nombre: String, val alias: String, val altura: Int, val edad: Int, val notas: String) {
    override fun toString(): String {
        return "Marvel (Nombre: $nombre, Alias: $alias, Altura: $altura, Edad: $edad, Notas: $notas"
    }
}