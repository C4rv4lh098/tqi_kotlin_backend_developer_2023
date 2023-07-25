package com.desafio.jumarket.dto.response

import com.desafio.jumarket.entity.Cliente

data class ClienteView(
        val clienteId: Long?,
        val nome: String
) {
    constructor(cliente: Cliente): this(
            clienteId = cliente.id,
            nome = cliente.nome
    )
}
