package com.desafio.jumarket.dto.request

import com.desafio.jumarket.entity.Carrinho
import com.desafio.jumarket.enummeration.Pagamento
import jakarta.validation.constraints.NotNull

class CarrinhoDto(
        @field:NotNull(message = "Invalid Input")
        val clienteId: Long,

        @field:NotNull(message = "Invalid Input")
        val produtoId: List<Long>,

        @field:NotNull(message = "Invalid Input")
        val pagamento: Pagamento
) {
    fun toEntity(): Carrinho = Carrinho(
            clienteId = this.clienteId,
            produtoId = this.produtoId,
            pagamento = this.pagamento
    )
}