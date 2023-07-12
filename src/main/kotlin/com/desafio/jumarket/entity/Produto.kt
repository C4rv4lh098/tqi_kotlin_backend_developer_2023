package com.desafio.jumarket.entity

import jakarta.persistence.*

@Entity
@Table(name = "Produto")
data class Produto(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(nullable = false)
        val nome: String = "",

        @Column(nullable = false)
        val unidadeMedida: String = "",

        @Column(nullable = false)
        var preco: Double,

        @ManyToOne
        var categoria: Categoria
)
