package com.desafio.jumarket.entity

import jakarta.persistence.*

@Entity
@Table(name = "Cliente")
data class Cliente(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(nullable = false)
        var nome: String = ""
)
