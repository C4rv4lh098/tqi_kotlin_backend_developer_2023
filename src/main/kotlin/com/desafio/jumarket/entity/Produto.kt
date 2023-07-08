package com.desafio.jumarket.entity

data class Produto(
        val id: Long,
        val nome: String = "",
        val medida: String = "",
        var preco: Double,
        val categoria: Categoria
)
