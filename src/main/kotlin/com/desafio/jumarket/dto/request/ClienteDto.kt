package com.desafio.jumarket.dto.request

import com.desafio.jumarket.entity.Cliente
import jakarta.validation.constraints.NotEmpty

data class ClienteDto(
       @field:NotEmpty(message = "Invalid Input")
        var nome: String

) {
    fun toEntity(): Cliente = Cliente(
            nome = this.nome
    )
}
