package com.desafio.jumarket.entity

data class Categoria(
        val id: Long,
        val nome: String = "",
        var produto: List<Produto> = mutableListOf()
)
