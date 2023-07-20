package com.desafio.jumarket.dto.request

import com.desafio.jumarket.entity.Produto
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class ProdutoUpdateDto(
        @field:NotEmpty(message = "Invalid Input")
        val unidadeMedida: String,

        @field:NotNull(message = "Invalid Input")
        val preco: Double,

) {
    fun toEntity(produto: Produto): Produto{
        produto.unidadeMedida = this.unidadeMedida
        produto.preco = this.preco
        return produto
    }
}
