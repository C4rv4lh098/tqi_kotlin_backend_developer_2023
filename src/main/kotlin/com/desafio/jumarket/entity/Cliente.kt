package com.desafio.jumarket.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "Cliente")
data class Cliente(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(nullable = false)
        var nome: String = "",

        @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE],
                mappedBy = "cliente")
        @JsonIgnore
        var compra: List<Compra> = mutableListOf()
)
