package com.desafio.jumarket.entity

import com.desafio.jumarket.enummeration.Pagamento
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "Compra")
data class Compra(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @ManyToOne
        val cliente: Cliente,

        @Column(nullable = false)
        var pagamento: Pagamento,

        @Column(nullable = false)
        var valorTotal: Double,

        @ManyToMany
        var produto: List<Produto>

)
