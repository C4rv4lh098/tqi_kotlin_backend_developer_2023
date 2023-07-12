package com.desafio.jumarket.entity

import jakarta.persistence.*
@Entity
@Table(name = "Categoria")
data class Categoria(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(nullable = false)
        val nome: String = "",

        @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE],
                mappedBy = "categoria")
        var produto: List<Produto> = mutableListOf()
)
