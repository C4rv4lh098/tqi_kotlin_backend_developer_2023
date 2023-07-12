package com.desafio.jumarket.dto.request

import com.desafio.jumarket.entity.Categoria
import com.desafio.jumarket.entity.Produto
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

class ProdutoDto(
        @field:NotEmpty(message = "Invalid Input")
        val nome: String,

        @field:NotEmpty(message = "Invalid Input")
        val unidadeMedida: String,

        @field:NotNull(message = "Invalid Input")
        val preco: Double,

        @field:NotNull(message = "Invalid Input")
        val categoriaId: Long
) {
    fun toEntity(): Produto = Produto(
            nome = this.nome,
            unidadeMedida = this.unidadeMedida,
            preco =  this.preco,
            categoria = Categoria(id = this.categoriaId)
    )

}