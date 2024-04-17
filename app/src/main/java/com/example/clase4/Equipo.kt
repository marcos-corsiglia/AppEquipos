package com.example.clase4

data class Equipo(
    val id: Int,
    val nombre: String,
    val apodo: String,
    val estadio: String,
    val escudo: String,
    val pais: Pais
)

enum class Pais{
    Argentina, Brasil, Colombia, Chile, Uruguay
}