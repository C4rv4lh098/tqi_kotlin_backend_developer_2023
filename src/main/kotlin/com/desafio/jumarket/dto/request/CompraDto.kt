package com.desafio.jumarket.dto.request

import com.desafio.jumarket.entity.Cliente
import com.desafio.jumarket.entity.Compra
import com.desafio.jumarket.entity.Produto
import com.desafio.jumarket.enummeration.Pagamento
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

class CompraDto(
        @field:NotNull(message = "Invalid Input")
        val clienteId: Long,

        @field:NotNull(message = "Invalid Input")
        val pagamento: Pagamento,

        @field:NotNull(message = "Invalid Input")
        val valorTotal: Double,

        @field:NotEmpty(message = "Invalid Input")
        val produto: List<Produto>
) {
    fun toEntity(): Compra = Compra(
            cliente = Cliente(id = this.clienteId),
            pagamento = this.pagamento,
            valorTotal = this.valorTotal,
            produto = this.produto
    )
}