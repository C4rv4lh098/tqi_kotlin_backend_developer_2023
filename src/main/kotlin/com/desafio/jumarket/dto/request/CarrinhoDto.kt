package com.desafio.jumarket.dto.request

import com.desafio.jumarket.entity.Carrinho
import com.desafio.jumarket.enummeration.Pagamento
import jakarta.validation.constraints.NotNull

class CarrinhoDto(
        @field:NotNull(message = "Invalid Input")
        val clienteId: Long,

        @field:NotNull(message = "Invalid Input")
        val produtoId: Long
) {
    fun toEntity(): Carrinho = Carrinho(
            clienteId = this.clienteId,
            produtoId = this.produtoId
    )
}