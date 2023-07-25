package com.desafio.jumarket.entity

import com.desafio.jumarket.enummeration.Pagamento
import jakarta.persistence.*

@Entity
@Table(name = "Carrinho")
data class Carrinho(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(nullable = false)
        var clienteId: Long,

        @Column(nullable = false)
        var produtoId: List<Long> = mutableListOf(),

        @Column(nullable = false)
        var pagamento: Pagamento

)
