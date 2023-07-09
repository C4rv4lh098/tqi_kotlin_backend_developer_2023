package com.desafio.jumarket.entity

import jakarta.persistence.*

@Entity
@Table(name = "Produto")
data class Produto(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(nullable = false)
        val nome: String = "",

        @Column(nullable = false)
        val unidade_Medida: String = "",

        @Column(nullable = false)
        var preco: Double,

        @ManyToOne
        val categoria: Categoria
)
