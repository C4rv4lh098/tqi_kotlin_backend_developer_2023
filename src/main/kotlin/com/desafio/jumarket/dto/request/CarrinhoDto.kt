package com.desafio.jumarket.dto.request

import com.desafio.jumarket.entity.Carrinho
import com.desafio.jumarket.entity.Produto
import com.desafio.jumarket.enummeration.Pagamento
import jakarta.validation.constraints.NotNull

class CarrinhoDto(
        val produto: List<Produto>,

        @field:NotNull(message = "Invalid Input")
        val valorTotal: Double,

        @field:NotNull(message = "Invalid Input")
        val pagamento: Pagamento
) {
    fun toEntity(): Carrinho = Carrinho(
            produto = this.produto,
            valorTotal = this.valorTotal,
            pagamento = this.pagamento
    )
}