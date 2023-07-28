package com.desafio.jumarket.entity

import com.fasterxml.jackson.annotation.JsonIgnore
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
        var unidadeMedida: String = "",

        @Column(nullable = false)
        var preco: Double,

        @ManyToOne
        var categoria: Categoria,

        @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE],
                mappedBy = "produto")
        @JsonIgnore
        var compra: List<Compra> = mutableListOf()
)
