package com.desafio.jumarket.entity

import com.desafio.jumarket.enummeration.Pagamento
import jakarta.persistence.*

@Entity
@Table(name = "Carrinho")
data class Carrinho(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @ManyToMany
        var produto: List<Produto> = mutableListOf(),

        @Column(nullable = false)
        var valorTotal: Double = calcularvalorTotal(produto),

        @Column(nullable = false)
        var pagamento: Pagamento
)

fun calcularvalorTotal(produto: List<Produto>): Double{
    var valorFinal: Double = 0.0
    for(item in produto){
        valorFinal += item.preco
    }
    return valorFinal
}