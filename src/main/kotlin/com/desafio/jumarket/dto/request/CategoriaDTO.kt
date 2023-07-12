package com.desafio.jumarket.dto.request


import com.desafio.jumarket.entity.Categoria
import jakarta.validation.constraints.NotEmpty

class CategoriaDTO (
        @field:NotEmpty(message = "Invalid Input")
        val nome: String
) {
        fun toEntity(): Categoria = Categoria(
                nome = this.nome
        )
}